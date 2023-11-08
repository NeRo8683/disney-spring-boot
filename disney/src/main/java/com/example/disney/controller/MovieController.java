/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.disney.controller;

import com.example.disney.dto.MovieDetailDTO;
import com.example.disney.dto.MovieListDTO;
import com.example.disney.dto.MovieUpdateDTO;
import com.example.disney.service.MovieService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author a
 */

@RestController
@RequestMapping("movies")
public class MovieController {
    
    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieListDTO>> getMovies(){
        List<MovieListDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok().body(movies);
}

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetailDTO> getMovieById(@PathVariable Long id){
        MovieDetailDTO movie = movieService.getMovieById(id);
        return ResponseEntity.ok().body(movie);
    }

    @PostMapping
    public ResponseEntity<MovieDetailDTO> saveMovie(@Valid @RequestBody MovieDetailDTO movie){
        MovieDetailDTO movieSaved = movieService.saveMovie(movie);
        return ResponseEntity.ok().body(movieSaved);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDetailDTO> updateMovie(@PathVariable Long id,@Valid @RequestBody MovieUpdateDTO movie){
        MovieDetailDTO movieUpdated = movieService.updateMovie(id, movie);
        return ResponseEntity.ok().body(movieUpdated);
    }

    @PostMapping("/{id}/characters/{idCharacter}")
    public ResponseEntity<String> postCharacter(@PathVariable Long id, @PathVariable Long idCharacter) {
        movieService.postCharacter(id, idCharacter);
        return ResponseEntity.ok().body("Character posted successfully");
    }

    @DeleteMapping("/{id}/characters/{idCharacter}")
    public ResponseEntity<String> deleteCharacter(@PathVariable Long id, @PathVariable Long idCharacter) {
        movieService.deleteCharacter(id, idCharacter);
        return ResponseEntity.ok().body("Character deleted successfully");
    }
}
    

