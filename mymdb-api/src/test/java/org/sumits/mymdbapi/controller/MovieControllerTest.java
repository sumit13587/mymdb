package org.sumits.mymdbapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sumits.mymdbapi.entity.Movie;
import org.sumits.mymdbapi.service.MovieService;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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
        when(mockMovieService.listAllMovies()).thenReturn(Collections.singletonList(new Movie()));
        assertEquals(1, classUnderTest.listMovies().size());
    }
}