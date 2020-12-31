package org.sumits.mymdbapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sumits.mymdbapi.domain.MovieDomain;
import org.sumits.mymdbapi.entity.Movie;
import org.sumits.mymdbapi.service.MovieService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/list")
    public List<MovieDomain> listMovies() {
        return movieService.listAllMovies();
    }

    @GetMapping("/findByActor")
    public List<MovieDomain> listMoviesByActor(@RequestParam String personName) {
        return movieService.findMoviesByActor(personName);
    }

    @GetMapping("/view")
    public MovieDomain viewMovieDetails(@RequestParam int movieId) {
        MovieDomain result = movieService.getMovieDetails(movieId);
        return result;
    }

    @PostMapping("/add")
    public MovieDomain addMovie(@RequestBody Movie movie) {
        return movieService.addNewMovie(movie);
    }

    @DeleteMapping("/delete")
    public boolean deleteMovie(@RequestParam int movieId) {
        movieService.deleteMovieById(movieId);
        MovieDomain result = movieService.getMovieDetails(movieId);
        return result == null;
    }

}
