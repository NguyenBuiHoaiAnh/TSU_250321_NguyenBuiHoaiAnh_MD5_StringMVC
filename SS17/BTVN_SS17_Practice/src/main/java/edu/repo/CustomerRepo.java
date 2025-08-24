package edu.repo;

import edu.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {

    Customer findByUsernameAndPassword(String username, String password);

    Customer findByEmail(String email);

    Customer findByPhone(String phone);

    Customer findByUsername(String username);
}
