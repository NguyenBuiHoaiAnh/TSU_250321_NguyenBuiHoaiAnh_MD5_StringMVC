package com.example.bt1_ss5.repo.ticket;

import com.example.bt1_ss5.model.Ticket;

import java.util.List;

public interface TicketDao {

    boolean insertTicket(Ticket ticket);

    List<String> getBookedSeatsByScheduleId(int scheduleId);

}
