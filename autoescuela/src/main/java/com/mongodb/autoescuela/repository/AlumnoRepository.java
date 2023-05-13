package com.mongodb.autoescuela.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.autoescuela.model.Alumno;


public interface AlumnoRepository extends MongoRepository<Alumno, String>{

}
