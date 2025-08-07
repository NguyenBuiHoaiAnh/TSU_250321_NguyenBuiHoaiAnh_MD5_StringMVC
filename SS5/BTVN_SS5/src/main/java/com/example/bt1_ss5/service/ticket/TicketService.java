package com.example.bt1_ss5.service.ticket;

import com.example.bt1_ss5.model.Ticket;

import java.util.List;

public interface TicketService {

    boolean addTicket(Ticket ticket);

    List<String> getBookedSeats(int scheduleId);
}
