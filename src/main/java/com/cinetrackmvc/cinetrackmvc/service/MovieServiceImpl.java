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

    @Override
    public List<Movie> findByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    @Override
    public List<Movie> findByDirectorName(String directorName) {
        return movieRepository.findByDirectorName(directorName);
    }

    @Override
    public void save(Movie movie) {
        movieRepository.saveMovie(movie);
    }

    @Override
    public Movie findById(int id) {
            return movieRepository.findById(id);
    }

}
