package ra.edu.service;

import ra.edu.model.Customer;
import ra.edu.model.Room;

import java.util.List;

public interface AdminService {
    int countCustomers();

    double getRevenueCurrentMonth();

    List<Room> getTop3RoomsBooked();

    List<Customer> getTop5CustomersBooked();
}
