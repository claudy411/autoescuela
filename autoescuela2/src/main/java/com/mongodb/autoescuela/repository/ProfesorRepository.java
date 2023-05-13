package com.mongodb.autoescuela.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.autoescuela.model.Profesor;

public interface ProfesorRepository extends MongoRepository<Profesor, String> {
	
}
