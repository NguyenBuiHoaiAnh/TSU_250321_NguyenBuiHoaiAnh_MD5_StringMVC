package com.example.bt2_ss1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("")
public class UserDataController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Gán dữ liệu người dùng
        req.setAttribute("id",1);
        req.setAttribute("name", "Huấn");
        req.setAttribute("email","huanrose@gmail.com");
        req.setAttribute("age",18);

        // Chuyển trang
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}