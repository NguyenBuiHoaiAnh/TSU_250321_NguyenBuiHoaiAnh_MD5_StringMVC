package com.example.bt1_ss5.model;

public class Movie {
    private int id;
    private String title;
    private String director;
    private String genre;
    private String description;
    private String duration;
    private String language;

    public Movie() {
    }

    public Movie(Integer id, String title, String director, String genre, String description, String duration, String language) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.description = description;
        this.duration = duration;
        this.language = language;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Movie{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", director='" + director + '\'' +
               ", genre='" + genre + '\'' +
               ", description='" + description + '\'' +
               ", duration='" + duration + '\'' +
               ", language='" + language + '\'' +
               '}';
    }
}
