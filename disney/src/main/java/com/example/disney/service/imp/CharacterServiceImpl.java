/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.disney.service.imp;

import com.example.disney.dto.CharacterDTO;
import com.example.disney.dto.CharacterListDTO;
import com.example.disney.mapper.CharacterMapper;
import com.example.disney.model.CharacterEntity;
import com.example.disney.repository.CharacterRepository;
import com.example.disney.service.CharacterService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a
 */
@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterMapper characterMapper;

    @Autowired
    private CharacterRepository characterRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public CharacterDTO save(CharacterDTO dto) {
        CharacterEntity characterEntity = characterMapper.characterDTO2Entity(dto);
        CharacterEntity characterEntitySaved = characterRepository.save(characterEntity);
        CharacterDTO result = characterMapper.characterEntity2DTO(characterEntitySaved);
        return result;
    }

    @Override
    public List<CharacterListDTO> getAllCharacters() {
        List<CharacterEntity> characters = characterRepository.findAll();
        List<CharacterListDTO> result = new ArrayList<>();
        for (CharacterEntity c : characters) {
            CharacterListDTO cDTO = modelMapper.map(c, CharacterListDTO.class);
            result.add(cDTO);
        }

        return result;
    }

    @Override
    public CharacterDTO getCharacterDetailsByID(Long id) {
        Optional<CharacterEntity> character = characterRepository.findById(id);
        if (!character.isPresent()) {
            throw new RuntimeException("Character with id " + id + " not found");
        }
        CharacterDTO result = characterMapper.characterEntity2DTO(character.get());
        return result;
    }

    @Override
    public CharacterDTO update(Long id, CharacterDTO character) {
        Optional<CharacterEntity> characterEntityToUpdate = characterRepository.findById(id);
        if (!characterEntityToUpdate.isPresent()) {
            throw new RuntimeException("Character with id " + id + " not found");
        }
        CharacterEntity characterToUpdate = characterEntityToUpdate.get();
        CharacterEntity characterEntityUpdated = characterRepository.save(characterMapper.characterUpdateMapper(character, characterToUpdate));
        return characterMapper.characterEntity2DTO(characterEntityUpdated);
    }

    @Override
    public void delete(Long id) {
        Optional<CharacterEntity> character = characterRepository.findById(id);
        if (!character.isPresent()) {
            throw new RuntimeException("Character with id " + id + " not found");
        }
        characterRepository.deleteById(id);
    }

}
