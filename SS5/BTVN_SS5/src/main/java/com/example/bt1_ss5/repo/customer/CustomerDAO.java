package com.example.bt1_ss5.repo.customer;

import com.example.bt1_ss5.model.Customer;

public interface CustomerDAO {
    // Login Check
    Customer checkUser(String username, String password);

}
