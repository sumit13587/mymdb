package org.sumits.mymdbapi.mapper;

import org.sumits.mymdbapi.domain.MovieDomain;
import org.sumits.mymdbapi.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieMapper {

    public static MovieDomain toDomain(Movie entity) {
        MovieDomain domain = new MovieDomain();
        domain.setMovieId(entity.getMovieId());
        domain.setTitle(entity.getTitle());
        domain.setBudget(entity.getBudget());
        domain.setHomepage(entity.getHomepage());
        domain.setMovieStatus(entity.getMovieStatus());
        domain.setOverview(entity.getOverview());
        domain.setPopularity(entity.getPopularity());
        domain.setReleaseDate(entity.getReleaseDate());
        domain.setRevenue(entity.getRevenue());
        domain.setRuntime(entity.getRuntime());
        domain.setTagline(entity.getTagline());
        domain.setVoteAverage(entity.getVoteAverage());
        domain.setVoteCount(entity.getVoteCount());
        return domain;
    }

    public static List<MovieDomain> toDomains(List<Movie> movieList) {
        List<MovieDomain> movieDomains = new ArrayList<>();
        for(Movie movie: movieList) {
            movieDomains.add(toDomain(movie));
        }
        return movieDomains;
    }

}
