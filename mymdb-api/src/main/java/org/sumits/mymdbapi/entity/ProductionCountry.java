package org.sumits.mymdbapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "production_country")
public class ProductionCountry implements Serializable {

    @Id
    @JoinColumn(name = "movie_id")
    @ManyToOne
    private Movie movie;

    @Id
    @JoinColumn(name = "country_id")
    @ManyToOne
    private Country country;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
