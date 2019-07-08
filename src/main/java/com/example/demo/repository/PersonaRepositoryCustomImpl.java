package com.example.demo.repository;
import org.springframework.data.domain.Pageable;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.demo.model.Persona;

public class PersonaRepositoryCustomImpl implements PersonaRepositoryCustom{
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Persona> searchPersona(String regex, Pageable pageable) {
		Criteria criteria = new Criteria();
		if ((regex != null ) && (!regex.trim().isEmpty())){
			criteria = criteria.orOperator(Criteria.where("nome").regex(regex, "i"),
					Criteria.where("cognome").regex(regex, "i"),
					Criteria.where("codiceFiscale").regex(regex, "i"));
		}
		 Query query = new Query(criteria);
		 if(pageable != null) {
			 query = query.with(pageable);
			 
		 }
		return mongoTemplate.find(query,  Persona.class);
		
	}
	
	
	

}
