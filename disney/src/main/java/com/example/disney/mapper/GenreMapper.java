/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.disney.mapper;

import com.example.disney.dto.GenreDTO;
import com.example.disney.model.GenreEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author a
 */
@Component
public class GenreMapper {
    
    public GenreEntity genreDTO2Entity(GenreDTO dto){
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setId(dto.getId());
        genreEntity.setName(dto.getName());
        return genreEntity;
    }

    public GenreDTO genreEntity2DTO(GenreEntity entity){
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(entity.getId());
        genreDTO.setName(entity.getName());
        return genreDTO;
    }
    
}
