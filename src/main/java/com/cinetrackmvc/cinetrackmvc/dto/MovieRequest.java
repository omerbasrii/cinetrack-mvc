package com.cinetrackmvc.cinetrackmvc.dto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
        @Min(value = 0, message = "IMDB score must be at least 0")
        @Max(value = 10, message = "IMDB score must not exceed 10")
        double imdbScore,
        @NotBlank(message = "Movie banner is required")
        @Pattern(regexp = "^(http|https)://.*", message = "Poster URL must be a valid link")
        String movieBanner
) {}
