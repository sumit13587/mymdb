package org.sumits.mymdbapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sumits.mymdbapi.domain.MovieDomain;
import org.sumits.mymdbapi.entity.Movie;
import org.sumits.mymdbapi.service.MovieService;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieControllerTest {

    private MovieController classUnderTest;

    @Mock
    private MovieService mockMovieService;

    @BeforeEach
    void setUp() {
        classUnderTest = new MovieController(mockMovieService);
    }

    @Test
    void listMovies() {
        when(mockMovieService.listAllMovies()).thenReturn(Collections.singletonList(new MovieDomain()));
        assertEquals(1, classUnderTest.listMovies().size());
    }

    @Test
    void listMoviesByActor() {
        when(mockMovieService.findMoviesByActor(anyString())).thenReturn(Collections.singletonList(new MovieDomain()));
        assertEquals(1, classUnderTest.listMoviesByActor("My Favorite Actor").size());
    }

    @Test
    void viewMovieDetails() {
        when(mockMovieService.getMovieDetails(anyInt())).thenReturn(stubMovie());
        MovieDomain movieDomain = classUnderTest.viewMovieDetails(101);
        assertEquals(101, movieDomain.getMovieId());
        assertEquals("My Favorite Movie", movieDomain.getTitle());
    }

    private MovieDomain stubMovie() {
        MovieDomain m = new MovieDomain();
        m.setMovieId(101);
        m.setTitle("My Favorite Movie");
        return m;
    }

    @Test
    void addMovie() {
        when(mockMovieService.addNewMovie(any(Movie.class))).thenReturn(stubMovie());
        MovieDomain movieDomain = classUnderTest.addMovie(new Movie());
        assertEquals(101, movieDomain.getMovieId());
        assertEquals("My Favorite Movie", movieDomain.getTitle());
    }

    @Test
    void deleteMovie() {
        doNothing().when(mockMovieService).deleteMovieById(anyInt());
        classUnderTest.deleteMovie(101);
        verify(mockMovieService, times(1)).deleteMovieById(anyInt());
    }
}