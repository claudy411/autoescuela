package com.mongodb.autoescuela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.autoescuela.model.Alumno;
import com.mongodb.autoescuela.model.Profesor;
import com.mongodb.autoescuela.repository.AlumnoRepository;
import com.mongodb.autoescuela.repository.ProfesorRepository;

@Service
public class AlumnoService {	
	
	@Autowired
	private AlumnoRepository repo;	
	
	@Autowired
	private ProfesorRepository repoProfesor;
	
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
	
//	public Alumno addProfesor(Alumno alumno,Profesor profesor) {
//		//recibe el alumno que se va a actualizar y el profesor que se va a añadir a ese mismo alumno
//		
//		List<Alumno> listadoAlumnos=profesor.getListadoAlumnos(); 
//		listadoAlumnos.add(alumno);//añade el alumno al listado de profesores
//		profesor.setListadoAlumnos(listadoAlumnos);
//		repoProfesor.save(profesor);//se guarda el profesor con el alumno añadido
//		alumno.setProfesor(profesor); //asigna el profesor al alumno
//
//		
//		return repo.save(alumno);
//		
//	}

}
