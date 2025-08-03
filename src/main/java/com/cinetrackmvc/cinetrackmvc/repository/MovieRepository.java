package com.cinetrackmvc.cinetrackmvc.repository;

import com.cinetrackmvc.cinetrackmvc.dto.MovieRequest;
import com.cinetrackmvc.cinetrackmvc.model.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class MovieRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Movie> getAllMovies()
    {
        return entityManager.createQuery("SELECT m from Movie m",Movie.class).getResultList();
    }

    @Transactional
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

    public Movie findByMovieName(String name){
        try{
            return entityManager.createQuery("SELECT m FROM Movie m WHERE m.movieName = :movieName", Movie.class)
                    .setParameter("movieName",name)
                    .getSingleResult();
        } catch (NoResultException e)
        {
            throw new NoSuchElementException("Movie not found this name");
        }
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
