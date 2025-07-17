package com.cinetrackmvc.cinetrackmvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotBlank(message = "Movie name is required")
    private String movieName;
    @NotBlank(message = "Director name is required")
    private String directorName;
    @NotBlank(message = "Genre is required")
    private String genre;
    @NotBlank(message = "IMDB score is required")
    private double imdbScore;
    @NotBlank(message = "Movie banner is required")
    @Pattern(regexp = "^(http|https)://.*", message = "Poster URL must be a valid link")
    private  String movieBanner;
    private LocalDateTime createdAt = LocalDateTime.now();
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
        return Id;
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

}
