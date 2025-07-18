package com.cinetrackmvc.cinetrackmvc.service;

import com.cinetrackmvc.cinetrackmvc.model.Movie;

import java.util.List;

public interface MovieService {

    public List<Movie> getMovies();

    public List<Movie> findByGenre(String genre);

    public List<Movie> findByDirectorName(String directorName);

    public void save(Movie movie);

    public Movie findById(int id);


}
