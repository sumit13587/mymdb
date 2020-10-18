package org.sumits.mymdbapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sumits.mymdbapi.entity.Movie;
import org.sumits.mymdbapi.service.MovieService;

import java.util.List;
import java.util.Optional;

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
    public List<Movie> listMovies() {
        return movieService.listAllMovies();
    }

    @GetMapping("/findByActor")
    public List<Movie> listMoviesByActor(@RequestParam String personName) {
        return movieService.findMoviesByActor(personName);
    }

    ;

    @GetMapping("/view")
    public Movie viewMovieDetails(@RequestParam int movieId) {
        Optional<Movie> result = movieService.getMovieDetails(movieId);
        return result.orElse(null);
    }

    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addNewMovie(movie);
    }

    @DeleteMapping("/delete")
    public boolean deleteMovie(@RequestParam int movieId) {
        movieService.deleteMovieById(movieId);
        Optional<Movie> result = movieService.getMovieDetails(movieId);
        return result.isEmpty();
    }

}
