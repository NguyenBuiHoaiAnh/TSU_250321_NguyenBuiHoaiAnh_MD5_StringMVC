package ra.edu.service;

import ra.edu.model.Customer;
import ra.edu.model.dto.LoginDTO;

import java.util.List;

public interface CustomerService {

    // Register
    boolean registerCustomer(Customer customer);

    // Login
    Customer getCustomer(LoginDTO loginDTO);

    // Customer List
    List<Customer> getAllCustomers();
}
