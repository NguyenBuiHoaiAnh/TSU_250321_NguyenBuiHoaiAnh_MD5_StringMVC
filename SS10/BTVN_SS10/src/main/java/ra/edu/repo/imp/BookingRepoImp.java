package ra.edu.repo.imp;

import org.springframework.stereotype.Repository;
import ra.edu.model.Booking;
import ra.edu.repo.BookingRepo;
import ra.edu.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;

@Repository
public class BookingRepoImp implements BookingRepo {
    @Override
    public boolean addBooking(Booking booking) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_booking(?,?,?,?)}");
            callSt.setLong(1, booking.getCustomerId());
            callSt.setLong(2, booking.getRoomId());
            callSt.setDate(3, Date.valueOf(booking.getBookingDate()));
            callSt.setDouble(4, booking.getPrice());
            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }
}
