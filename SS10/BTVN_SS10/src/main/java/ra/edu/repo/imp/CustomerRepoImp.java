package ra.edu.repo.imp;

import org.springframework.stereotype.Repository;
import ra.edu.model.Customer;
import ra.edu.model.dto.LoginDTO;
import ra.edu.repo.CustomerRepo;
import ra.edu.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepoImp implements CustomerRepo {
    // Register
    @Override
    public boolean registerCustomer(Customer customer){
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call register_customer(?,?,?,?,?)}");
            callSt.setString(1,customer.getFullName());
            callSt.setString(2,customer.getPhoneNumber());
            callSt.setString(3,customer.getEmail());
            callSt.setString(4,customer.getPassword());
            callSt.setString(5,customer.getAddress());
            callSt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return false;
    }

    // Login
    @Override
    public Customer getCustomer(LoginDTO loginDTO){
        Connection conn = null;
        CallableStatement callSt = null;
        Customer customer = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call customer_login(?,?)}");
            callSt.setString(1, loginDTO.getEmail());
            callSt.setString(2, loginDTO.getPassword());
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFullName(rs.getString("full_name"));
                customer.setPhoneNumber(rs.getString("phone_number"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
                customer.setAddress(rs.getString("address"));
                customer.setRole(rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return customer;
    }

    // Get All Customer
    @Override
    public List<Customer> getAllCustomers() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Customer> customersList = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_all_customer()}");
            ResultSet rs = callSt.executeQuery();
            customersList = new ArrayList<>();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFullName(rs.getString("full_name"));
                customer.setPhoneNumber(rs.getString("phone_number"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
                customer.setAddress(rs.getString("address"));
                customer.setRole(rs.getString("role"));
                customersList.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }

        return customersList;
    }

}
