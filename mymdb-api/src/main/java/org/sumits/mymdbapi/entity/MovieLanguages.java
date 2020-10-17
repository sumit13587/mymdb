package org.sumits.mymdbapi.entity;

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
    @ManyToOne
    private Movie movie;

    @Id
    @JoinColumn(name = "person_id")
    @ManyToOne
    private Language language;

    @Id
    @JoinColumn(name = "person_id")
    @ManyToOne
    private LanguageRole languageRole;

}
