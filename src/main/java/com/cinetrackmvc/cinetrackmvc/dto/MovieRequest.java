package com.cinetrackmvc.cinetrackmvc.dto;

public record MovieRequest(

        String movieName,
        String directorName,
        String genre,
        double imdbScore,
        String movieBanner
) {}
