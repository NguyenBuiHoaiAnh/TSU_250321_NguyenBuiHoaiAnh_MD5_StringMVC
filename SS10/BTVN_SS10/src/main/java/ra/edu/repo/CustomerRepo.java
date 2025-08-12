package ra.edu.repo;

import ra.edu.model.Customer;
import ra.edu.model.dto.LoginDTO;

import java.util.List;

public interface CustomerRepo {

    // Register
    public boolean registerCustomer(Customer customer);

    // Login
    public Customer getCustomer(LoginDTO loginDTO);

    // Get All Customer
    public List<Customer> getAllCustomers();
}
