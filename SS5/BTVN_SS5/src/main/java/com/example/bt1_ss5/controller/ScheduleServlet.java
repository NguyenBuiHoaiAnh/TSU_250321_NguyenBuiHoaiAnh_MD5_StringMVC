package com.example.bt1_ss5.controller;

import com.example.bt1_ss5.model.Movie;
import com.example.bt1_ss5.model.Schedule;
import com.example.bt1_ss5.model.ScreenRoom;
import com.example.bt1_ss5.service.movies.MoviesService;
import com.example.bt1_ss5.service.movies.imp.MoviesServiceImp;
import com.example.bt1_ss5.service.schedule.ScheduleService;
import com.example.bt1_ss5.service.schedule.imp.ScheduleServiceImp;
import com.example.bt1_ss5.service.screenroom.ScreenRoomService;
import com.example.bt1_ss5.service.screenroom.imp.ScreenRoomServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet ("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {

    private ScheduleService scheduleService;
    private ScreenRoomService screenRoomService;
    private MoviesService moviesService;

    public ScheduleServlet() {
        scheduleService = new ScheduleServiceImp();
        screenRoomService = new ScreenRoomServiceImp();
        moviesService = new MoviesServiceImp();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action.equals("Create")) {
            // Add
            addSchedules(req, resp);
        } else if (action.equals("Update")) {
            // Update
            updateSchedules(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action.equals("findAll")) {
            // Display
            displaySchedule(req, resp);
        } else if (action.equals("addForm")) {
            // Add Option
            optionAddSchedule(req, resp);

        } else if (action.equals("initUpdate")) {
            // Find by ID (update)
            int scheduleID = Integer.parseInt(req.getParameter("id"));

            Schedule schedule = scheduleService.getSchedulesById(scheduleID);

            List<ScreenRoom> screenRoomList = screenRoomService.getScreenRooms();
            List<Movie> movieList = moviesService.findAllMovies();

            req.setAttribute("screenRoomList", screenRoomList);
            req.setAttribute("movieList", movieList);

            req.setAttribute("schedule", schedule);
            req.getRequestDispatcher("views/ScheduleAndScrRooms/editSchedule.jsp").forward(req, resp);
        } else if (action.equals("Delete")) {
            // Delete
            deleteSchedules(req, resp);
        }
    }

    public void displaySchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Schedule> scheduleList = scheduleService.getAllSchedules();
        scheduleList.forEach(System.out::println);

        req.setAttribute("scheduleList", scheduleList);
        req.getRequestDispatcher("/views/ScheduleAndScrRooms/listSchedule.jsp").forward(req, resp);
    }

    public void optionAddSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ScreenRoom> screenRoomList = screenRoomService.getScreenRooms();
        List<Movie> movieList = moviesService.findAllMovies();
        req.setAttribute("screenRoomList", screenRoomList);
        req.setAttribute("movieList", movieList);
        req.getRequestDispatcher("/views/ScheduleAndScrRooms/addSchedule.jsp").forward(req, resp);
    }

    public void addSchedules(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. Lấy dữ liệu submit từ form trong request
        int movieId = Integer.parseInt(req.getParameter("movieId"));
        int screenRoomId = Integer.parseInt(req.getParameter("screenRoomId"));
        LocalDateTime showTime = LocalDateTime.parse(req.getParameter("showTime"));
        int availableSeats = Integer.parseInt(req.getParameter("availableSeats"));
        String format = req.getParameter("format");

        Schedule schedule = new Schedule();
        schedule.setMovieId(movieId);
        schedule.setScreenRoomId(screenRoomId);
        schedule.setShowTime(showTime);
        schedule.setAvailableSeats(availableSeats);
        schedule.setFormat(format);

        //2. Gọi sang service thực hiện thêm mới
        boolean result = scheduleService.addSchedules(schedule);
        //3. Xử lý kết quả service trả về
        if (result) {
            displaySchedule(req, resp);
        } else {
            req.getRequestDispatcher("views/ScheduleAndScrRooms/error.jsp").forward(req, resp);
        }
    }

    // Update And Delete

    public void updateSchedules(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Thực hiện cập nhật danh mục
        //1. Lấy dữ liệu trên form
        int id = Integer.parseInt(req.getParameter("id"));
        int movieId = Integer.parseInt(req.getParameter("movieId"));
        int screenRoomId = Integer.parseInt(req.getParameter("screenRoomId"));
        LocalDateTime showTime = LocalDateTime.parse(req.getParameter("showTime"));
        int availableSeats = Integer.parseInt(req.getParameter("availableSeats"));
        String format = req.getParameter("format");

        Schedule schedule = new Schedule();
        schedule.setMovieId(id);
        schedule.setMovieId(movieId);
        schedule.setScreenRoomId(screenRoomId);
        schedule.setShowTime(showTime);
        schedule.setAvailableSeats(availableSeats);
        schedule.setFormat(format);

        //2. Gọi service thực hiện cập nhật
        boolean result = scheduleService.updateSchedules(schedule);
        //3. Xử lý kết quả
        if (result) {
            displaySchedule(req, resp);
        } else {
            req.getRequestDispatcher("views/ScheduleAndScrRooms/error.jsp").forward(req, resp);
        }
    }

    public void deleteSchedules(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int deleteID = Integer.parseInt(req.getParameter("id"));
        boolean result = moviesService.deleteMovies(deleteID);
        if (result) {
            displaySchedule(req, resp);
        } else {
            req.getRequestDispatcher("views/ScheduleAndScrRooms/error.jsp").forward(req, resp);
        }
    }

}
