package com.cinetrackmvc.cinetrackmvc.dto;

public record MovieResponse(
        int id,
        String movieName,
        String directorName,
        String genre,
        double imdbScore,
        String movieBanner
) {}
