package com.example.bt1_ss5.repo.customer.imp;

import com.example.bt1_ss5.repo.customer.CustomerDAO;
import com.example.bt1_ss5.model.Customer;
import com.example.bt1_ss5.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class CustomerDAOImp implements CustomerDAO {

    // Login
    @Override
    public Customer checkUser(String username, String password) {
        Connection conn = null;
        CallableStatement callSt = null;
        Customer customer = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call login(?,?)}");
            callSt.setString(1, username);
            callSt.setString(2, password);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                customer = new Customer();
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customer.setRole(Customer.Role.valueOf(rs.getString("role")));
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally{
            ConnectionDB.closeConnection(conn, callSt);
        }

        return customer;
    }
}
