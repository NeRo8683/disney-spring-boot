/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.disney.repository;

import com.example.disney.model.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author a
 */
@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long>{
    
}