package com.cinetrackmvc.cinetrackmvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record MovieRequest(

        @NotBlank(message = "Movie name is required")
        String movieName,
        @NotBlank(message = "Director name is required")
        String directorName,
        @NotBlank(message = "Genre is required")
        String genre,
        @NotBlank(message = "IMDB score is required")
        double imdbScore,
        @NotBlank(message = "Movie banner is required")
        @Pattern(regexp = "^(http|https)://.*", message = "Poster URL must be a valid link")
        String movieBanner
) {}
