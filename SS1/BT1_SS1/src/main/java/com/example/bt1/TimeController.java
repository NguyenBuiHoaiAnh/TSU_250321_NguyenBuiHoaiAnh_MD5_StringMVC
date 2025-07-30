package com.example.bt1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@WebServlet (urlPatterns = "/TimeController")
public class TimeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Định dạng thời gian theo tiếng Việt
        SimpleDateFormat dtf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
        String timeDTF = dtf.format(new Date());

        req.setAttribute("time", timeDTF);

        // Chuyển trang
         req.getRequestDispatcher("showtime.jsp").forward(req,resp);

    }
}