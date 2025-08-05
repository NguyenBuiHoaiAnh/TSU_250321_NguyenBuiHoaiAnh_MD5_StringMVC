package com.example.bt1_ss5.service.movies.imp;

import com.example.bt1_ss5.model.Movie;
import com.example.bt1_ss5.repo.movie.MovieDAO;
import com.example.bt1_ss5.repo.movie.imp.MovieDAOImp;
import com.example.bt1_ss5.service.movies.MoviesService;

import java.util.List;

public class MoviesServiceImp implements MoviesService {

    private MovieDAO movieDAO;

    public MoviesServiceImp() {
        movieDAO = new MovieDAOImp();
    }

    // Display
    @Override
    public List<Movie> findAllMovies() {
        return movieDAO.findAllMovies();
    }

    // Add
    @Override
    public boolean addMovies(Movie movie) {
        return movieDAO.addMovies(movie);
    }


    // Update And Delete
    @Override
    public Movie getMovieById(int id) {
        return movieDAO.getMovieById(id);
    }

    @Override
    public boolean updateMovies(Movie movie) {
        return movieDAO.updateMovies(movie);
    }

    @Override
    public boolean deleteMovies(int id) {
        return movieDAO.deleteMovies(id);
    }
}
