package ra.edu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.model.Customer;
import ra.edu.model.dto.LoginDTO;
import ra.edu.repo.CustomerRepo;
import ra.edu.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    // Register
    @Override
    public boolean registerCustomer(Customer customer) {
        return customerRepo.registerCustomer(customer);
    }

    // Login
    @Override
    public Customer getCustomer(LoginDTO loginDTO) {
        return customerRepo.getCustomer(loginDTO);
    }

    // Customer List
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.getAllCustomers();
    }


}
