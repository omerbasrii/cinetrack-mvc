package com.cinetrackmvc.cinetrackmvc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String movieName;
    private String directorName;
    private String genre;
    private double imdbScore;
    private  String movieBanner;


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
