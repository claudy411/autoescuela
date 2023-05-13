package com.mongodb.autoescuela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.autoescuela.model.Clase;
import com.mongodb.autoescuela.model.Profesor;
import com.mongodb.autoescuela.repository.ClaseRepository;

@Service
public class ClaseService {
	
	@Autowired
	private ClaseRepository repo;
	
	public Clase guardarClase(Clase clase) {
		return repo.save(clase);
	}
	
	public List<Clase> listarTodasClases(){
		return repo.findAll();
	}
	
	public Clase listarClaseId(String id) {
		return repo.findById(id).orElse(null);
	}
	
	public void eliminarClase(String id) {
		repo.deleteById(id);
	}
	

}
