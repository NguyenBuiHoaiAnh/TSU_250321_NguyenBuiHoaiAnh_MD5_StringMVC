package edu.service.imp;

import edu.model.entity.Customer;
import edu.repo.CustomerRepo;
import edu.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Customer login(String username, String password) {
        return customerRepo.findByUsernameAndPassword(username, password);
    }

    @Override
    public boolean checkUsernameExisted(String username) {
        return customerRepo.findByUsername(username) != null;
    }

    @Override
    public boolean checkEmailExisted(String email) {
        return customerRepo.findByEmail(email) != null;
    }

    @Override
    public boolean checkPhoneExisted(String phone) {
        return customerRepo.findByPhone(phone) != null;
    }

    @Override
    public Customer registerCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public boolean checkComfirmPassword(String password, String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }

}
