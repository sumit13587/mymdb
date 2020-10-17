package org.sumits.mymdbapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movie_company")
public class MovieCompany implements Serializable  {

    @Id
    @JoinColumn(name = "movie_id")
    @ManyToOne
    private Movie movie;

    @Id
    @JoinColumn(name = "company_id")
    @ManyToOne
    private ProductionCompany productionCompany;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public ProductionCompany getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(ProductionCompany productionCompany) {
        this.productionCompany = productionCompany;
    }
}
