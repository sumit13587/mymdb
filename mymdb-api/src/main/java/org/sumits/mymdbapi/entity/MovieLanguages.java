package org.sumits.mymdbapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movie_languages")
public class MovieLanguages implements Serializable {

    @Id
    @JoinColumn(name = "person_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Movie movie;

    @Id
    @JoinColumn(name = "person_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Language language;

    @Id
    @JoinColumn(name = "person_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private LanguageRole languageRole;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public LanguageRole getLanguageRole() {
        return languageRole;
    }

    public void setLanguageRole(LanguageRole languageRole) {
        this.languageRole = languageRole;
    }
}
