/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.disney.dto;

import com.example.disney.model.MovieEntity;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author a
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDTO {

    private Long id;

    private String image;

    @NotNull
    private String name;

    @NotNull
    @PositiveOrZero
    private Integer age;
    @NotNull
    @PositiveOrZero
    private Double weight;
    @NotNull
    private String history;
    private List<MovieEntity> movies;

    @Override
    public String toString() {
        return "CharacterDTO{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", age=" + age
                + ", weight=" + weight
                + ", history='" + history + '\''
                + ", movies=" + movies
                + '}';
    }

}
