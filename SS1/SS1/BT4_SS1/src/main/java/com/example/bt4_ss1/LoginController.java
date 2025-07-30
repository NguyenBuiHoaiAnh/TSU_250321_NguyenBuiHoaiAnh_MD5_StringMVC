package com.example.bt4_ss1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("NguyenVanA") && password.equals("matkhauco8kytu")) {
            req.getRequestDispatcher("homepage.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}