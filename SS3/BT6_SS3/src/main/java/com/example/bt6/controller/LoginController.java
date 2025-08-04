package com.example.bt6.controller;

import com.example.bt6.model.UserLogin;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        System.out.println("name: " + name);

        UserLogin userLogin = new UserLogin();

        if (name.equals("admin") || password.equals("123456789")) {
            userLogin.setLogin(true);
        }

        if (userLogin.isLogin()) {
            req.getRequestDispatcher("/views/student.jsp").forward(req,resp);
        } else  {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}