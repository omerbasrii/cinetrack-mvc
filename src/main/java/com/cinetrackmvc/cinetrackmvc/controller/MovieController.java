package com.cinetrackmvc.cinetrackmvc.controller;


import com.cinetrackmvc.cinetrackmvc.model.Movie;
import com.cinetrackmvc.cinetrackmvc.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("movies/genre")
    public List<Movie> getMoviesByGenre(@RequestParam String name) {
        return movieService.findByGenre(name);
    }

    @GetMapping("movies/director")
    public List<Movie> getMovieByDirectorName(@RequestParam String directorName) {
        return movieService.findByDirectorName(directorName);
    }

    @PostMapping("movies/")
    public ResponseEntity<String> addMovie(@RequestBody @Valid Movie movie) {
        movieService.save(movie);
        return ResponseEntity.ok("Movie added successfully.");
    }
}
