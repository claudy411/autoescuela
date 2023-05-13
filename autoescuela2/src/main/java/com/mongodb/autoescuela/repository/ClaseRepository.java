package com.mongodb.autoescuela.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.autoescuela.model.Clase;

public interface ClaseRepository extends MongoRepository<Clase, String> {

}
