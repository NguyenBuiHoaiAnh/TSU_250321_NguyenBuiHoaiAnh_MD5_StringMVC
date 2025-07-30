package com.example.bt5;

import java.io.*;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String cfpassword = req.getParameter("cfpassword");

        boolean hasError = false;

        if (Validator.isEmpty(username)) {
            req.setAttribute("error1", "Username is required");
            hasError = true;
        }

        if (Validator.isEmpty(email)) {
            req.setAttribute("error2", "Email is required");
            hasError = true;
        } else if (!Validator.validateEmail(email)) {
            req.setAttribute("error2", "Invalid Email");
            hasError = true;
        }

        if (Validator.isEmpty(password)) {
            req.setAttribute("error3", "Password is required");
            hasError = true;
        } else if (!Validator.validatePassword(password)) {
            req.setAttribute("error3", "Invalid Password");
            hasError = true;
        }

        if (Validator.isEmpty(cfpassword)) {
            req.setAttribute("error4", "Confirm Password is required");
            hasError = true;
        } else if (!cfpassword.equals(password)) {
            req.setAttribute("error4", "Confirm Password does not match");
            hasError = true;
        }

        if (hasError) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            req.setAttribute("success", "Registered Successfully");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }


    }
}