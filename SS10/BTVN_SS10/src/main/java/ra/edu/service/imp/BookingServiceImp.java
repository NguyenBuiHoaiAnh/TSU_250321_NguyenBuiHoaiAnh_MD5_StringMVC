package ra.edu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.edu.model.Booking;
import ra.edu.repo.BookingRepo;
import ra.edu.service.BookingService;

@Repository
public class BookingServiceImp implements BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Override
    public boolean addBooking(Booking booking) {
        return bookingRepo.addBooking(booking);
    }
}
