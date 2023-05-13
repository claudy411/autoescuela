package com.mongodb.autoescuela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.autoescuela.model.Alumno;
import com.mongodb.autoescuela.repository.AlumnoRepository;

@Service
public class AlumnoService {	
	
	@Autowired
	private AlumnoRepository repo;	
	
	public Alumno guardarAlumno(Alumno alumno) { 
		return repo.save(alumno);
	}
	
	public List<Alumno> listarTodos(){
		return repo.findAll();
	}
	
	public Alumno listarPorId(String id) {
		return repo.findById(id).orElse(null);
	}
	
	public void eliminarAlumno(String id) {
		repo.deleteById(id);
	}

}
