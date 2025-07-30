package com.example.bt6_ss1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/NoteServlet")
public class NoteServlet extends HttpServlet {

    private static final List<String> todoList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String taskInput = req.getParameter("taskInput");
        if (taskInput != null || taskInput.trim().isEmpty()) {
            todoList.add(taskInput);
        }
        req.setAttribute("todo", todoList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}