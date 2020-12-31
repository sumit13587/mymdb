package org.sumits.mymdbapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;
import org.sumits.mymdbapi.domain.MovieDomain;
import org.sumits.mymdbapi.entity.Movie;
import org.sumits.mymdbapi.entity.Person;
import org.sumits.mymdbapi.repository.MovieRepository;
import org.sumits.mymdbapi.repository.PersonRepository;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    private MovieService classUnderTest;

    @Mock
    private MovieRepository mockMovieRepository;
    @Mock
    private PersonRepository mockPersonRepository;

    @BeforeEach
    void setUp() {
        classUnderTest = new MovieService(mockMovieRepository, mockPersonRepository);
    }

    @Test
    void listAllMovies() {
        when(mockMovieRepository.findAll()).thenReturn(Collections.singletonList(new Movie()));
        assertEquals(1, classUnderTest.listAllMovies().size());
    }

    @Test
    void findMoviesByCast() {
        when(mockPersonRepository.findByPersonName(anyString())).thenReturn(stubPerson());
        when(mockMovieRepository.findAll(any(Specification.class))).thenReturn(Collections.singletonList(new Movie()));
        assertEquals(1, classUnderTest.findMoviesByActor("My Favorite Actor").size());
    }

    private Person stubPerson() {
        Person p = new Person();
        p.setPersonId(101);
        p.setPersonName("My Favorite Actor");
        return p;
    }

    @Test
    void getMovieDetails() {
        when(mockMovieRepository.findById(anyInt())).thenReturn(Optional.of(stubMovie()));
        MovieDomain result = classUnderTest.getMovieDetails(101);
        assertEquals(101, result.getMovieId());
        assertEquals("My Favorite Movie", result.getTitle());
    }

    private Movie stubMovie() {
        Movie m = new Movie();
        m.setMovieId(101);
        m.setTitle("My Favorite Movie");
        return m;
    }

    @Test
    void addNewMovie() {
        when(mockMovieRepository.save(any(Movie.class))).thenReturn(stubMovie());
        MovieDomain newMovie = classUnderTest.addNewMovie(new Movie());
        assertEquals(101, newMovie.getMovieId());
        assertEquals("My Favorite Movie", newMovie.getTitle());
    }

    @Test
    void deleteMovieById() {
        doNothing().when(mockMovieRepository).deleteById(anyInt());
        classUnderTest.deleteMovieById(101);
        verify(mockMovieRepository, times(1)).deleteById(anyInt());
    }
}