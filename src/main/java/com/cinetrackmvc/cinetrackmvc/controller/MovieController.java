package com.cinetrackmvc.cinetrackmvc.controller;

import com.cinetrackmvc.cinetrackmvc.dto.MovieRequest;
import com.cinetrackmvc.cinetrackmvc.dto.MovieResponse;
import com.cinetrackmvc.cinetrackmvc.mapper.MovieMapper;
import com.cinetrackmvc.cinetrackmvc.model.Movie;
import com.cinetrackmvc.cinetrackmvc.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieController(MovieService movieService, MovieMapper movieMapper) {

        this.movieService = movieService;
        this.movieMapper = movieMapper;

    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/movies/{id}")
    public MovieResponse getMovieById(@PathVariable int id) {
        MovieResponse movie = movieMapper.toResponse(movieService.findById(id));
        if(movie == null)
        {
            throw new NoSuchElementException("Movie not found");
        }
        return movie;
    }

    @GetMapping("movies/genre")
        public List<MovieResponse> getMoviesByGenre(@RequestParam String name) {

        List<MovieResponse> movies = movieMapper.toResponseList(movieService.findByGenre(name));

        if (movies == null)
        {
            throw new NoSuchElementException("Genres not found");
        };
        return movies;
    }

    @GetMapping("movies/director")
    public List<MovieResponse> getMovieByDirectorName(@RequestParam String directorName) {

        List<MovieResponse> movies = movieMapper.toResponseList(movieService.findByDirectorName(directorName));
        if(movies == null)
        {
            throw new NoSuchElementException("This director's movies could not be found!!!!");
        }
        return movies;
    }

    @PostMapping("movies/")
    public ResponseEntity<String> addMovie(@RequestBody @Valid MovieRequest movieRequest) {
        Movie movie = movieMapper.toMovieEntity(movieRequest);
        movieService.save(movie);
        return ResponseEntity.ok("Movie added successfully.");
    }
}
