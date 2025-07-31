package com.example.bt2_ss2;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("userLogin")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        req.setAttribute("name", name);
        req.setAttribute("email", email);
        req.getRequestDispatcher("userInfo").forward(req, resp);
    }
}