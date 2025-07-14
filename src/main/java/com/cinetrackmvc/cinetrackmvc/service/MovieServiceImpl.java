package com.cinetrackmvc.cinetrackmvc.service;

import com.cinetrackmvc.cinetrackmvc.model.Movie;
import com.cinetrackmvc.cinetrackmvc.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository)
    {
        this.movieRepository=movieRepository;
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.getAllMovies();
    }
}
