package edu.service;

import edu.model.entity.Customer;

public interface CustomerService {

    Customer login(String username, String password);

    boolean checkUsernameExisted(String username);

    boolean checkEmailExisted(String email);

    boolean checkPhoneExisted(String phoneNumber);

    Customer registerCustomer(Customer customer);

    boolean checkComfirmPassword(String password, String confirmPassword);

}
