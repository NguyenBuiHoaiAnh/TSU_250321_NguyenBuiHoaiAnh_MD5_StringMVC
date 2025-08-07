package com.example.bt1_ss5.controller;

import com.example.bt1_ss5.model.Ticket;
import com.example.bt1_ss5.model.UserSession;
import com.example.bt1_ss5.service.ticket.TicketService;
import com.example.bt1_ss5.service.ticket.imp.TicketServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/TicketServlet")
public class TicketServlet extends HttpServlet {
    private TicketService ticketService = new TicketServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Check login and role USER
        HttpSession session = req.getSession();
        UserSession userSession = (UserSession) session.getAttribute("userSession");
        if (userSession == null || !"USER".equals(userSession.getRole())) {
            resp.sendRedirect("login.jsp");
            return;
        }

        int scheduleId = Integer.parseInt(req.getParameter("scheduleId"));
        List<String> bookedSeats = ticketService.getBookedSeats(scheduleId);

        req.setAttribute("scheduleId", scheduleId);
        req.setAttribute("bookedSeats", bookedSeats);
        req.getRequestDispatcher("/views/Ticket/ticket.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserSession userSession = (UserSession) session.getAttribute("userSession");
        if (userSession == null || !"USER".equals(userSession.getRole())) {
            resp.sendRedirect("login.jsp");
            return;
        }

        int customerId = userSession.getCustomerId();
        int scheduleId = Integer.parseInt(req.getParameter("scheduleId"));
        String[] selectedSeats = req.getParameterValues("seats");

        if (selectedSeats != null) {
            for (String seat : selectedSeats) {
                Ticket ticket = new Ticket();
                ticket.setCustomerId(customerId);
                ticket.setScheduleId(scheduleId);
                ticket.setSeatName(seat);
                ticket.setTotalMoney(50000.0); // tạm cố định
                ticketService.addTicket(ticket);
            }
        }

        req.setAttribute("success", "Đặt vé thành công!");
        resp.sendRedirect("HomeServlet?action=findAll");
    }
}
