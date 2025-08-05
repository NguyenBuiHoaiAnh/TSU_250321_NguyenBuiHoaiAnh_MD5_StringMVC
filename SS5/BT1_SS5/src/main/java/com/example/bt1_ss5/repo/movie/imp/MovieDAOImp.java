package com.example.bt1_ss5.repo.movie.imp;

import com.example.bt1_ss5.model.Movie;
import com.example.bt1_ss5.repo.movie.MovieDAO;
import com.example.bt1_ss5.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOImp implements MovieDAO {

    // Find All
    @Override
    public List<Movie> findAllMovies() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Movie> moviesList = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call display_movies()}");
            ResultSet rs = callSt.executeQuery();
            moviesList = new ArrayList<>();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setGenre(rs.getString("genre"));
                movie.setDescription(rs.getString("description"));
                movie.setDuration(rs.getString("duration"));
                movie.setLanguage(rs.getString("language"));
                moviesList.add(movie);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }

        return moviesList;
    }

    // Add
    @Override
    public boolean addMovies(Movie movie) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_movies(?,?,?,?,?,?)}");

            callSt.setString(1, movie.getTitle());
            callSt.setString(2, movie.getDirector());
            callSt.setString(3, movie.getGenre());
            callSt.setString(4, movie.getDescription());
            callSt.setString(5, movie.getDuration());
            callSt.setString(6, movie.getLanguage());
            callSt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    // Update And Delete
    @Override
    public Movie getMovieById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Movie movie = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setGenre(rs.getString("genre"));
                movie.setDescription(rs.getString("description"));
                movie.setDuration(rs.getString("duration"));
                movie.setLanguage(rs.getString("language"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return movie;
    }

    @Override
    public boolean updateMovies(Movie movie) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_movie(?,?,?,?,?,?,?)}");
            callSt.setInt(1, movie.getId());
            callSt.setString(2, movie.getTitle());
            callSt.setString(3, movie.getDirector());
            callSt.setString(4, movie.getGenre());
            callSt.setString(5, movie.getDescription());
            callSt.setString(6, movie.getDuration());
            callSt.setString(7, movie.getLanguage());
            callSt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    // Delete
    @Override
    public boolean deleteMovies(int id) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_movie(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }
}
