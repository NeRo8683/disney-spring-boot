/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.disney.service;

import com.example.disney.dto.MovieDetailDTO;
import com.example.disney.dto.MovieListDTO;
import com.example.disney.dto.MovieUpdateDTO;
import java.util.List;

/**
 *
 * @author a
 */
public interface MovieService {

    List<MovieListDTO> getAllMovies();
    MovieDetailDTO getMovieById(Long id);
    MovieDetailDTO saveMovie(MovieDetailDTO movie);
    void deleteMovie(Long id);
    MovieDetailDTO updateMovie(Long id, MovieUpdateDTO movie);
    MovieDetailDTO postCharacter(Long id, Long idCharacter);
    void deleteCharacter(Long id, Long idCharacter);
}
