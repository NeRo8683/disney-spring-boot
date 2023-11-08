/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.disney.dto;

import java.time.LocalDate;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author a
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieUpdateDTO {

    private Long id;
    @NotNull
    private String image;
    @NotNull
    private String title;
    private LocalDate creationDate;
    @NotNull
    @Min(1)
    @Max(5)
    private int score;
    @NotNull
    private Long genreId;

}
