package com.mongodb.autoescuela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.autoescuela.model.Alumno;
import com.mongodb.autoescuela.model.Profesor;
import com.mongodb.autoescuela.repository.ProfesorRepository;

@Service
public class ProfesorService {
	
	@Autowired
	private ProfesorRepository repo;
	
	public Profesor guardarProfesor(Profesor profesor) {
		return repo.save(profesor);
	}
	
	public List<Profesor> listarTodosProfesor(){
		return repo.findAll();
	}
	
	public Profesor listarProfesorId(String id) {
		return repo.findById(id).orElse(null);
	}
	
	public void eliminarProfesor(String id) {
		repo.deleteById(id);
	}

	public List<Alumno> listarAlumnosPorProfesor(String idProfesor){

		Profesor profe= repo.findById(idProfesor).orElse(null);
		
		List<Alumno> listado=profe.getListadoAlumnos();
		
		return listado;
	}
}
