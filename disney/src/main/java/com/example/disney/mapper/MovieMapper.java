/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.disney.mapper;

import com.example.disney.dto.CharacterMovieDTO;
import com.example.disney.dto.MovieDetailDTO;
import com.example.disney.dto.MovieUpdateDTO;
import com.example.disney.model.CharacterEntity;
import com.example.disney.model.MovieEntity;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 *
 * @author a
 */
@Component
public class MovieMapper {
    
    public ModelMapper modelMapper = new ModelMapper();

    public static void addCharacter(MovieEntity movieEntity, CharacterEntity characterEntity) {
        Set<CharacterEntity> characters = movieEntity.getCharacters();
        characters.add(characterEntity);
    }

    public static void removeCharacter(MovieEntity movieEntity, CharacterEntity characterEntity) {
        Set<CharacterEntity> characters = movieEntity.getCharacters();
        characters.remove(characterEntity);
    }

    public MovieDetailDTO movieEntityToDTO(MovieEntity movieEntity) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Set<CharacterMovieDTO> characters = new HashSet<>();
        for (CharacterEntity c : movieEntity.getCharacters()) {
            CharacterMovieDTO characterDTO = modelMapper.map(c, CharacterMovieDTO.class);
            characters.add(characterDTO);
        }
        MovieDetailDTO movieDTO = modelMapper.map(movieEntity, MovieDetailDTO.class);
        movieDTO.setCharacters(characters);
        return movieDTO;
    }

    public MovieEntity movieDTOToEntity(MovieDetailDTO movieDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Set<CharacterEntity> characters = new HashSet<>();
        for (CharacterMovieDTO c : movieDTO.getCharacters()) {
            CharacterEntity characterEntity = modelMapper.map(c, CharacterEntity.class);
            characters.add(characterEntity);
        }
        MovieEntity movieEntity = modelMapper.map(movieDTO, MovieEntity.class);
        movieEntity.setCreationDate(LocalDate.now());
        movieEntity.setCharacters(characters);
        return movieEntity;
    }

    public MovieEntity updateMovieMapper(MovieUpdateDTO movieDTO, MovieEntity movieToUpdate) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        MovieEntity movie = modelMapper.map(movieDTO, MovieEntity.class);

        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setImage(movie.getImage());
        movieToUpdate.setScore(movie.getScore());
        movieToUpdate.setGenreId(movie.getGenreId());

        return movieToUpdate;
    }
}
