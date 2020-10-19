package org.sumits.mymdbapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movie")
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;

    private String title;

    private int budget;

    private String homepage;

    private String overview;

    private double popularity;

    private Date releaseDate;

    private long revenue;

    private int runtime;

    @Column(name = "movie_status")
    private String movieStatus;

    private String tagline;

    @Column(name = "vote_average")
    private double voteAverage;

    @Column(name = "vote_count")
    private int voteCount;

//    @OneToMany
//    @JoinColumn(name = "movie_id")
//    @JsonIgnore
//    private List<MovieCast> movieCasts;
//
//    @OneToMany
//    @JoinColumn(name = "movie_id")
//    @JsonIgnore
//    private List<MovieCrew> movieCrews;
//
//    @OneToMany
//    @JoinColumn(name = "movie_id")
//    @JsonIgnore
//    private List<MovieCompany> movieCompanies;
//
//    @OneToMany
//    @JoinColumn(name = "movie_id")
//    @JsonIgnore
//    private List<MovieGenre> movieGenres;
//
//    @OneToMany
//    @JoinColumn(name = "movie_id")
//    @JsonIgnore
//    private List<MovieKeywords> movieKeywords;
//
//    @OneToMany
//    @JoinColumn(name = "movie_id")
//    @JsonIgnore
//    private List<MovieLanguages> movieLanguages;
//
//    @OneToMany
//    @JoinColumn(name = "movie_id")
//    @JsonIgnore
//    private List<ProductionCountry> productionCountries;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(String movieStatus) {
        this.movieStatus = movieStatus;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

//    public List<MovieCast> getMovieCasts() {
//        return movieCasts;
//    }
//
//    public void setMovieCasts(List<MovieCast> movieCasts) {
//        this.movieCasts.addAll(movieCasts);
//    }
//
//    public List<MovieCrew> getMovieCrews() {
//        return movieCrews;
//    }
//
//    public void setMovieCrews(List<MovieCrew> movieCrews) {
//        this.movieCrews.addAll(movieCrews);
//    }
//
//    public List<MovieCompany> getMovieCompanies() {
//        return movieCompanies;
//    }
//
//    public void setMovieCompanies(List<MovieCompany> movieCompanies) {
//        this.movieCompanies.addAll(movieCompanies);
//    }
//
//    public List<MovieGenre> getMovieGenres() {
//        return movieGenres;
//    }
//
//    public void setMovieGenres(List<MovieGenre> movieGenres) {
//        this.movieGenres.addAll(movieGenres);
//    }
//
//    public List<MovieKeywords> getMovieKeywords() {
//        return movieKeywords;
//    }
//
//    public void setMovieKeywords(List<MovieKeywords> movieKeywords) {
//        this.movieKeywords.addAll(movieKeywords);
//    }
//
//    public List<MovieLanguages> getMovieLanguages() {
//        return movieLanguages;
//    }
//
//    public void setMovieLanguages(List<MovieLanguages> movieLanguages) {
//        this.movieLanguages.addAll(movieLanguages);
//    }
//
//    public List<ProductionCountry> getProductionCountries() {
//        return productionCountries;
//    }
//
//    public void setProductionCountries(List<ProductionCountry> productionCountries) {
//        this.productionCountries.addAll(productionCountries);
//    }
}
