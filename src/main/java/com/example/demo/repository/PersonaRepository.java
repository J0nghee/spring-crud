package com.example.demo.repository;

import java.util.*;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.*;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, String>, PersonaRepositoryCustom {
	//definisco le mie query
	
	//?0 corrisponde al primo parametro String tag
	
	List<Persona> findByTags(String tag);
		
	
}
