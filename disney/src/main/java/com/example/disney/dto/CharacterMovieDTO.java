/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.disney.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author a
 */
public class CharacterMovieDTO {

    private Long id;
    @NotNull
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

}
