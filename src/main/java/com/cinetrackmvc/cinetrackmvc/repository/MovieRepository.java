package com.cinetrackmvc.cinetrackmvc.repository;

import com.cinetrackmvc.cinetrackmvc.model.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class MovieRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Movie> getAllMovies()
    {
        return entityManager.createQuery("SELECT m from Movie m",Movie.class).getResultList();
    }

    public void saveMovie(Movie movie)
    {
        entityManager.persist(movie);
    }

    public void updateMovie(Movie movie)
    {
        entityManager.merge(movie);
    }

    public Movie findById(int id)
    {
        return entityManager.find(Movie.class,id);
    }

    public List<Movie> findByDirectorName(String directorName)
    {
        TypedQuery<Movie> m = entityManager.createQuery("SELECT m FROM Movie m WHERE m.directorName = :directorName", Movie.class);
        m.setParameter("directorName", directorName);
        return m.getResultList();
    }


    public List<Movie> findByGenre(String genre) {
        return entityManager.createQuery("SELECT m FROM Movie m WHERE m.genre = :genre", Movie.class)
                .setParameter("genre", genre)
                .getResultList();
    }

}
