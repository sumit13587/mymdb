package org.sumits.mymdbapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movie_cast")
public class MovieCast implements Serializable {

    @Id
    @JoinColumn(name = "movie_id")
    @ManyToOne(targetEntity = Movie.class)
    private Movie movie;

    @Id
    @JoinColumn(name = "gender_id")
    @ManyToOne(targetEntity = Gender.class)
    private Gender gender;

    @Id
    @JoinColumn(name = "person_id")
    @ManyToOne(targetEntity = Person.class)
    private Person person;

    @Id
    @Column(name = "character_name")
    private String characterName;

    @Id
    @Column(name = "cast_order")
    private int castOrder;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getCastOrder() {
        return castOrder;
    }

    public void setCastOrder(int castOrder) {
        this.castOrder = castOrder;
    }
}
