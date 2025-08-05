package com.example.bt1_ss5.controller;

import com.example.bt1_ss5.repo.customer.CustomerDAO;
import com.example.bt1_ss5.repo.customer.imp.CustomerDAOImp;
import com.example.bt1_ss5.model.Customer;
import com.example.bt1_ss5.model.UserSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private CustomerDAO customerDAO;

    public LoginServlet() {
        customerDAO = new CustomerDAOImp();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Customer customer = customerDAO.checkUser(username, password);

        System.out.println(customer);
        if (customer != null) {
            UserSession.customer = customer;
            if (customer.getRole() == Customer.Role.ADMIN) {
                resp.sendRedirect("views/admin.jsp");
            } else {
                resp.sendRedirect("views/home.jsp");
            }
        } else {
            req.setAttribute("error", "Invalid credentials.");
            req.getRequestDispatcher("views/login.jsp").forward(req, resp);
        }

    }
}