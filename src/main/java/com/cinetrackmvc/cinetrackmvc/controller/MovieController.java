package com.cinetrackmvc.cinetrackmvc.controller;


import com.cinetrackmvc.cinetrackmvc.model.Movie;
import com.cinetrackmvc.cinetrackmvc.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService)
    {
        this.movieService=movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies()
    {
        return movieService.getMovies();
    }

}
