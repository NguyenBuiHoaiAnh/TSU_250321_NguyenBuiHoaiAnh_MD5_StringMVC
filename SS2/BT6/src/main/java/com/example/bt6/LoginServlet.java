package com.example.bt6;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean isValid = true;
        if (username.equals("admin") && password.equals("123456")) {

            req.setAttribute("isValid", true);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            req.setAttribute("isValid", false);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}