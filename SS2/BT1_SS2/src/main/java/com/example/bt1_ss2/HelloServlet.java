package com.example.bt1_ss2;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", "Nguyễn Văn A");
        req.setAttribute("age", 25);
        req.setAttribute("hobby", "Đọc sách, du lịch, và lập trình");
        req.setAttribute("about", "Tôi là 1 lập trình viên đam mê công nghệ," +
                                  " luôn tìm kiếm cơ hội để học hỏi và phát triển bản thân.");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}