package com.example.bt1_ss5.model;

import java.time.LocalDate;
import java.util.Date;

public class Schedule {
    private int id;
    private String movieTitle;
    private int movieId;
    private LocalDate showTime;
    private int screenRoomId;
    private int availableSeats;
    private String format;

    public Schedule() {
    }

    public Schedule(int id, String movieTitle, int movieId, LocalDate showTime, int screenRoomId, int availableSeats, String format) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.movieId = movieId;
        this.showTime = showTime;
        this.screenRoomId = screenRoomId;
        this.availableSeats = availableSeats;
        this.format = format;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public LocalDate getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDate showTime) {
        this.showTime = showTime;
    }

    public int getScreenRoomId() {
        return screenRoomId;
    }

    public void setScreenRoomId(int screenRoomId) {
        this.screenRoomId = screenRoomId;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
