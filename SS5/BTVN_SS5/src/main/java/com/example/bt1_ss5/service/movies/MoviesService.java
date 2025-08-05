package com.example.bt1_ss5.service.movies;

import com.example.bt1_ss5.model.Movie;

import java.util.List;

public interface MoviesService {
    // Display
    List<Movie> findAllMovies();

    // Add
    boolean addMovies(Movie movie);

    // Update And Delete
    Movie getMovieById(int id);

    boolean updateMovies(Movie movie);

    boolean deleteMovies(int id);
}
