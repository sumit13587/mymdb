package org.sumits.mymdbapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sumits.mymdbapi.entity.Movie;
import org.sumits.mymdbapi.repository.MovieRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieService {

    @Autowired
    private final MovieRepository movieRepository;

    @PersistenceContext
    private EntityManager em;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional
    public List<Movie> listAllMovies() {
        return (List<Movie>)movieRepository.findAll();
    }

    public Optional<Movie> getMovieDetails(int movieId) { return movieRepository.findById(movieId); };
}
