package org.sumits.mymdbapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sumits.mymdbapi.entity.Movie;
import org.sumits.mymdbapi.repository.MovieRepository;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    private MovieService classUnderTest;

    @Mock
    private MovieRepository mockMovieRepository;

    @BeforeEach
    void setUp() {
        classUnderTest = new MovieService(mockMovieRepository);
    }

    @Test
    void listMovies() {
        when(mockMovieRepository.findAll()).thenReturn(Collections.singletonList(new Movie()));
        assertEquals(1, classUnderTest.listAllMovies().size());
    }

}