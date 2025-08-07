package com.example.bt1_ss5.repo.ticket.imp;

import com.example.bt1_ss5.model.Ticket;
import com.example.bt1_ss5.repo.ticket.TicketDao;
import com.example.bt1_ss5.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImp implements TicketDao {
    @Override
    public boolean insertTicket(Ticket ticket) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_screenroom(?,?,?,?)}");
            callSt.setInt(1, ticket.getCustomerId());
            callSt.setInt(2,ticket.getScheduleId());
            callSt.setString(3,ticket.getSeatName());
            callSt.setDouble(4,ticket.getTotalMoney());
            callSt.executeUpdate();
            return true;

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public List<String> getBookedSeatsByScheduleId(int scheduleId) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<String> bookedSeats = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_booked_seats_by_schedule_id(?)}");
            callSt.setInt(1, scheduleId);
            ResultSet rs = callSt.executeQuery();

            bookedSeats = new ArrayList<>();
            while (rs.next()) {
                String seat = rs.getString("seat_name");
                bookedSeats.add(seat);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return bookedSeats;
    }
}
