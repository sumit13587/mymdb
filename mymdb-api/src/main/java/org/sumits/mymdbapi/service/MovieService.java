package org.sumits.mymdbapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sumits.mymdbapi.entity.Movie;
import org.sumits.mymdbapi.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> listAllMovies() {
        return (List<Movie>)movieRepository.findAll();
    }
}
