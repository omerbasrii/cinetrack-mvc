package com.cinetrackmvc.cinetrackmvc.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "movie_name", nullable = false, length = 255)
    private String movieName;
    @Column(name = "director_name", length = 255)
    private String directorName;
    @Column(name = "genre", length = 100)
    private String genre;
    @Column(name = "imdb_score")
    private double imdbScore;
    @Column(name = "movie_banner")
    private  String movieBanner;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Movie(){}

    public Movie(String movieName, String directorName, String genre, double imdbScore, String movieBanner) {
        this.movieName = movieName;
        this.directorName = directorName;
        this.genre = genre;
        this.imdbScore = imdbScore;
        this.movieBanner = movieBanner;
        this.createdAt = LocalDateTime.now();
    }


    public int getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setImdbScore(double imdbScore) {
        this.imdbScore = imdbScore;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getGenre() {
        return genre;
    }

    public double getImdbScore() {
        return imdbScore;
    }

    public String getMovieBanner() {
        return movieBanner;
    }

    public void setMovieBanner(String movieBanner) {
        this.movieBanner = movieBanner;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

}
