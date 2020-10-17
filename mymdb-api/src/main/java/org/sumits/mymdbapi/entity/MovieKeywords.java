package org.sumits.mymdbapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movie_keywords")
public class MovieKeywords implements Serializable {

    @Id
    @JoinColumn(name = "movie_id")
    @ManyToOne
    private Movie movie;

    @Id
    @JoinColumn(name = "keyword_id")
    @ManyToOne
    private Keyword keyword;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Keyword getKeyword() {
        return keyword;
    }

    public void setKeyword(Keyword keyword) {
        this.keyword = keyword;
    }
}
