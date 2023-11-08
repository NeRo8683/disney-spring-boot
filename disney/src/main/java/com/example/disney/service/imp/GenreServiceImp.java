/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.disney.service.imp;

import com.example.disney.dto.GenreDTO;
import com.example.disney.mapper.GenreMapper;
import com.example.disney.model.GenreEntity;
import com.example.disney.repository.GenreRepository;
import com.example.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a
 */
@Service
public class GenreServiceImp implements GenreService{

    @Autowired
    private GenreMapper genreMapper;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public GenreDTO addGenre(GenreDTO dto) {
        GenreEntity genreEntity = genreRepository.save(genreMapper.genreDTO2Entity(dto));
        return genreMapper.genreEntity2DTO(genreEntity);
    }
}
