package com.example.bt1_ss5.service.ticket.imp;

import com.example.bt1_ss5.model.Ticket;
import com.example.bt1_ss5.repo.ticket.TicketDao;
import com.example.bt1_ss5.repo.ticket.imp.TicketDaoImp;
import com.example.bt1_ss5.service.ticket.TicketService;

import java.util.List;

public class TicketServiceImp implements TicketService {

    private TicketDao ticketDAO = new TicketDaoImp();

    @Override
    public boolean addTicket(Ticket ticket) {
        return ticketDAO.insertTicket(ticket);
    }

    @Override
    public List<String> getBookedSeats(int scheduleId) {
        return ticketDAO.getBookedSeatsByScheduleId(scheduleId);
    }
}
