package com.example.bt2;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/controller")
public class StudentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String address = req.getParameter("address");

        boolean isExist = true;

        if (name == null) {
            isExist = false;
        } else if (age < 0 || age > 100) {
            isExist = false;
        } else if (address == null) {
            isExist = false;
        }

        if (!isExist) {
            req.setAttribute("message", "Please enter your name");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            req.setAttribute("name", name);
            req.setAttribute("age", age);
            req.setAttribute("address", address);
            req.getRequestDispatcher("studentList.jsp").forward(req, resp);
        }
    }
}