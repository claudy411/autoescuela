package com.mongodb.autoescuela.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mongodb.autoescuela.model.Alumno;
import com.mongodb.autoescuela.model.Profesor;
import com.mongodb.autoescuela.service.ProfesorService;

@RestController
@RequestMapping("/api/roan/profesores")
@CrossOrigin
public class ProfesorController {
	
	@Autowired
	private ProfesorService service;
	
	@PostMapping
	public ResponseEntity<Profesor> guardarProfesor(@RequestBody Profesor profesor){
		Profesor profesorBd=service.guardarProfesor(profesor);
		return new ResponseEntity<Profesor>(profesorBd,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Profesor>> listarTodosProfesor(){
		List<Profesor> listarTodoProfesor=service.listarTodosProfesor();
		return new ResponseEntity<List<Profesor>>(listarTodoProfesor,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Profesor> listarProfesorid(@PathVariable String id){
		Profesor profesorBd=service.listarProfesorId(id);
		return new ResponseEntity<Profesor>(profesorBd,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarProfesorId(@PathVariable String id){
		service.eliminarProfesor(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Profesor> actualizar(@RequestBody Profesor profesor){
		Profesor profeBbdd= service.listarProfesorId(profesor.getId());
		
		if(profeBbdd == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El profesor no existe");
		}
		Profesor actualizado= service.guardarProfesor(profesor);
		
		return new ResponseEntity<Profesor>(actualizado,HttpStatus.CREATED);
	}

	@GetMapping("/alumnos/{id}")
	public ResponseEntity<List<Alumno>> listadoAlumnosPorProfesor(@PathVariable String id){
		
		List<Alumno> listado= service.listarAlumnosPorProfesor(id);
		System.err.println(listado.size());
		return new ResponseEntity<List<Alumno>>(listado,HttpStatus.OK);
	}
	
	@PutMapping("/alumnos/{id}")
	public ResponseEntity<Profesor> actualizarListado(@RequestBody Alumno alumno, @PathVariable String id){
		
		Profesor profeBbdd= service.listarProfesorId(id);

		if(profeBbdd == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El profesor no existe");
		}
		//Obtener la lista de alumnos
		List<Alumno> listado= profeBbdd.getListadoAlumnos();
		listado.add(alumno);
		profeBbdd.setListadoAlumnos(listado);
		Profesor actualizado= service.guardarProfesor(profeBbdd);
		return new ResponseEntity<Profesor>(actualizado,HttpStatus.CREATED);
		
	}
}
