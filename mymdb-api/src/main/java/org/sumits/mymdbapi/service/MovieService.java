package org.sumits.mymdbapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.sumits.mymdbapi.entity.Movie;
import org.sumits.mymdbapi.entity.Person;
import org.sumits.mymdbapi.repository.MovieRepository;
import org.sumits.mymdbapi.repository.MovieSpecifications;
import org.sumits.mymdbapi.repository.PersonRepository;

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

    @Autowired
    private final PersonRepository personRepository;

    @PersistenceContext
    private EntityManager em;

    public MovieService(MovieRepository movieRepository, PersonRepository personRepository) {
        this.movieRepository = movieRepository;
        this.personRepository = personRepository;
    }

    @Transactional
    public List<Movie> listAllMovies() {
        return movieRepository.findAll();
    }

    @Transactional
    public List<Movie> findMoviesByActor(String personName) {
        Person person = personRepository.findByPersonName(personName);
        Specification<Movie> spec = MovieSpecifications.hasActor(person.getPersonId());
        return movieRepository.findAll(spec);
    }

    @Transactional
    public Optional<Movie> getMovieDetails(int movieId) {
        return movieRepository.findById(movieId);
    }

    @Transactional
    public Movie addNewMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Transactional
    public void deleteMovieById(int movieId) {
        movieRepository.deleteById(movieId);
    }
}
