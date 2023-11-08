/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.disney.controller;

import com.example.disney.dto.GenreDTO;
import com.example.disney.service.GenreService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author a
 */
@RestController
@RequestMapping("genres")
public class GenreController {
    
     @Autowired
    private GenreService genreService;

    @PostMapping
    public GenreDTO addGenre(@Valid @RequestBody GenreDTO genre) {
        return genreService.addGenre(genre);
    }
    
}
