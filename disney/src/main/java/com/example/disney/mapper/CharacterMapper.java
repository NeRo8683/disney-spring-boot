/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.disney.mapper;

import com.example.disney.dto.CharacterDTO;
import com.example.disney.model.CharacterEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author a
 */
@Component
public class CharacterMapper {
        public CharacterEntity characterDTO2Entity(CharacterDTO dto){
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setImage(dto.getImage());
        characterEntity.setId(dto.getId());
        characterEntity.setName(dto.getName());
        characterEntity.setAge(dto.getAge());
        characterEntity.setWeight(dto.getWeight());
        characterEntity.setHistory(dto.getHistory());
        characterEntity.setMovies(dto.getMovies());
        return characterEntity;
    }

    public CharacterDTO characterEntity2DTO(CharacterEntity entity){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setImage(entity.getImage());
        characterDTO.setId(entity.getId());
        characterDTO.setName(entity.getName());
        characterDTO.setAge(entity.getAge());
        characterDTO.setWeight(entity.getWeight());
        characterDTO.setHistory(entity.getHistory());
        characterDTO.setMovies(entity.getMovies());

        return characterDTO;
    }

    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> characters) {
        List<CharacterDTO> charactersDTOS = new ArrayList<>();
        for (CharacterEntity character : characters){
            charactersDTOS.add(characterEntity2DTO(character));
        }
        return charactersDTOS;
    }

   public CharacterEntity characterUpdateMapper(CharacterDTO character, CharacterEntity characterToUpdate){
      characterToUpdate.setImage(character.getImage());
       characterToUpdate.setName(character.getName());
       characterToUpdate.setAge(character.getAge());
       characterToUpdate.setHistory(character.getHistory());
       characterToUpdate.setWeight(character.getWeight());
       characterToUpdate.setMovies(character.getMovies());

       return characterToUpdate;
   }

}
