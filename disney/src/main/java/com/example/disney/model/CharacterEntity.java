/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.disney.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author a
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private String name;
    private Integer age;
    private Double weight;
    private String history;
    private boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "characters",
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JsonIgnore
    private List<MovieEntity> movies = new ArrayList<>();

    public void addMovie(MovieEntity movieEntity) {
        movies.add(movieEntity);
    }

    public void removeMovie(MovieEntity movieToRemoveCharacters) {
        movies.remove(movieToRemoveCharacters);
    }

}
