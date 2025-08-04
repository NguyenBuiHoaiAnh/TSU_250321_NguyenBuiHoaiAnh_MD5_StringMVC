package com.example.bt2.controller;

import java.io.*;

import com.example.bt2.model.Student;
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
            Student student = new Student();
            student.setName(name);
            student.setAge(age);
            student.setAddress(address);
            req.setAttribute("student", student);
            req.getRequestDispatcher("/views/studentList.jsp").forward(req, resp);
        }
    }
}