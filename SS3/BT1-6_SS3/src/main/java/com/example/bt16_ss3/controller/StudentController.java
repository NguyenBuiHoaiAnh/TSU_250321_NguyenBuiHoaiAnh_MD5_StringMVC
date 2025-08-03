package com.example.bt16_ss3.controller;

import com.example.bt16_ss3.dao.StudentDAO;
import com.example.bt16_ss3.dao.imp.StudentDAOImp;
import com.example.bt16_ss3.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
    private StudentDAO studentDAO;

    public StudentController() {
        studentDAO = new StudentDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("findAll")) {
            displayStudents(req, resp);
        }


    }

    public void displayStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Display Student
        List<Student> studentList = studentDAO.displayAllStudents();
        studentList.forEach(System.out::println);

        req.setAttribute("studentList",studentList);
        req.getRequestDispatcher("/views/studentList.jsp").forward(req,resp);
    }
}