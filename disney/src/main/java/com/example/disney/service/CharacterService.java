/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.disney.service;

import com.example.disney.dto.CharacterDTO;
import com.example.disney.dto.CharacterListDTO;
import java.util.List;

/**
 *
 * @author a
 */
public interface CharacterService {

    CharacterDTO save(CharacterDTO dto);
    List<CharacterListDTO> getAllCharacters();
    CharacterDTO getCharacterDetailsByID(Long id);
    CharacterDTO update(Long id, CharacterDTO character);
    void delete(Long id);

}
