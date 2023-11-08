/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.disney.dto;

import java.time.LocalDate;
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
public class MovieListDTO {

    private Long id;
    private String image;
    private String title;
    private LocalDate creationDate;

}
