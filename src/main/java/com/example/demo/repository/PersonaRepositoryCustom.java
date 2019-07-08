package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.demo.model.Persona;


public interface PersonaRepositoryCustom {
	
	List<Persona> searchPersona(String regex, Pageable pageable);
}
