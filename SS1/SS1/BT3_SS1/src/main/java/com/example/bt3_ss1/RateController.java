package com.example.bt3_ss1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/convert")
public class RateController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Lấy dữ liệu bên index
        double rate = Double.parseDouble(req.getParameter("rate"));
        double usd = Double.parseDouble(req.getParameter("usd"));

        // Thực hiện logic bên Java
        double vnd = rate * usd;

        req.setAttribute("rate", rate);
        req.setAttribute("usd", usd);
        req.setAttribute("vnd", vnd);

        // Chuyển trang
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}