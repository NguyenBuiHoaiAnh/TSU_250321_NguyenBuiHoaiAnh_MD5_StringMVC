package ra.edu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.model.Customer;
import ra.edu.model.Room;
import ra.edu.repo.AdminRepo;
import ra.edu.service.AdminService;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public int countCustomers() {
        return adminRepo.countCustomers();
    }

    @Override
    public double getRevenueCurrentMonth() {
        return adminRepo.getRevenueCurrentMonth();
    }

    @Override
    public List<Room> getTop3RoomsBooked() {
        return adminRepo.getTop3RoomsBooked();
    }

    @Override
    public List<Customer> getTop5CustomersBooked() {
        return adminRepo.getTop5CustomersBooked();
    }
}
