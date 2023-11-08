/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.disney.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author a
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    private String title;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;

    private int score;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id", updatable = false, insertable = false)
    private GenreEntity genre;

    @Column(name = "genre_id")
    private Long genreId;

    private boolean deleted = Boolean.FALSE;

    @ManyToMany(
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(
            name = "character_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    @JsonIgnore
    private Set<CharacterEntity> characters = new HashSet<>();

    public MovieEntity(String image, String title, int score, GenreEntity genre,
            Set<CharacterEntity> characters) {
        this.image = image;
        this.title = title;
        this.score = score;
        this.genre = genre;
        this.characters = characters;
    }

    public void addCharacter(CharacterEntity characterEntity) {
        characters.add(characterEntity);
    }

    public void removeCharacter(CharacterEntity characterEntity) {
        characters.remove(characterEntity);
    }

}
