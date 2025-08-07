package com.example.bt1_ss5.controller;

import com.example.bt1_ss5.model.Movie;
import com.example.bt1_ss5.model.Schedule;
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
import java.util.List;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    private MoviesService moviesService;
    private ScreenRoomService screenRoomService;
    private ScheduleService scheduleService;

    public HomeServlet() {
        scheduleService = new ScheduleServiceImp();
        screenRoomService = new ScreenRoomServiceImp();
        moviesService = new MoviesServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action.equals("findAll")) {
            // Display
            displayMovie(req, resp);
        } else if (action.equals("detail")) {
            displayMovieAndSchedule(req, resp);
        }
    }

    public void displayMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movie> moviesList = moviesService.findAllMovies();

        req.setAttribute("moviesList", moviesList);
        req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
    }

    public void displayMovieAndSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int movieId = Integer.parseInt(req.getParameter("id"));
        Movie movie = moviesService.getMovieById(movieId);
        List<Schedule> scheduleList = screenRoomService.getScheduleByMovieID(movieId);

        req.setAttribute("movie", movie);
        req.setAttribute("scheduleList", scheduleList);
        req.getRequestDispatcher("/views/MovieDetails/movieDetail.jsp").forward(req, resp);
    }


}
