package com.example.bt1_ss5.controller;

import com.example.bt1_ss5.model.Movie;
import com.example.bt1_ss5.repo.movie.MovieDAO;
import com.example.bt1_ss5.service.movies.MoviesService;
import com.example.bt1_ss5.service.movies.imp.MoviesServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet ("/MovieServlet")
public class MovieServlet extends HttpServlet {
    private MoviesService moviesService;

    public MovieServlet() {
        moviesService = new MoviesServiceImp();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action.equals("Create")) {
            // Add
            addMovie(req, resp);
        } else if (action.equals("Update")) {
            // Update
            updateMovie(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action.equals("findAll")) {
            // Display
            displayMovie(req, resp);
        } else if (action.equals("initUpdate")) {
            // Find by ID (update)
            int movieID = Integer.parseInt(req.getParameter("id"));
            Movie movie = moviesService.getMovieById(movieID);
            req.setAttribute("movie", movie);
            req.getRequestDispatcher("views/Movies/formUpdateMovie.jsp").forward(req, resp);
        } else if (action.equals("Delete")) {
            // Delete
            deleteMovie(req, resp);
        }
    }

    public void displayMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movie> moviesList = moviesService.findAllMovies();
        moviesList.forEach(System.out::println);

        req.setAttribute("moviesList", moviesList);
        req.getRequestDispatcher("/views/Movies/listMovie.jsp").forward(req, resp);
    }

    public void addMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. Lấy dữ liệu submit từ form trong request
        Movie movie = new Movie();
        movie.setTitle(req.getParameter("title"));
        movie.setDirector(req.getParameter("director"));
        movie.setGenre(req.getParameter("genre"));
        movie.setDescription(req.getParameter("description"));
        movie.setDuration(req.getParameter("duration"));
        movie.setLanguage(req.getParameter("language"));
        //2. Gọi sang service thực hiện thêm mới
        boolean result = moviesService.addMovies(movie);
        //3. Xử lý kết quả service trả về
        if (result) {
            displayMovie(req, resp);
        } else {
            req.getRequestDispatcher("views/Movies/error.jsp").forward(req, resp);
        }
    }

    // Update And Delete
    public void updateMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Thực hiện cập nhật danh mục
        //1. Lấy dữ liệu trên form
        Movie movie = new Movie();
        movie.setId(Integer.parseInt(req.getParameter("id")));
        movie.setTitle(req.getParameter("title"));
        movie.setDirector(req.getParameter("director"));
        movie.setGenre(req.getParameter("genre"));
        movie.setDescription(req.getParameter("description"));
        movie.setDuration(req.getParameter("duration"));
        movie.setLanguage(req.getParameter("language"));

        //2. Gọi service thực hiện cập nhật
        boolean result = moviesService.updateMovies(movie);
        //3. Xử lý kết quả
        if (result) {
            displayMovie(req, resp);
        } else {
            req.getRequestDispatcher("views/Movies/error.jsp").forward(req, resp);
        }
    }

    public void deleteMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int deleteID = Integer.parseInt(req.getParameter("id"));
        boolean result = moviesService.deleteMovies(deleteID);
        if (result) {
            displayMovie(req, resp);
        } else {
            req.getRequestDispatcher("views/Movies/error.jsp").forward(req, resp);
        }
    }

}
