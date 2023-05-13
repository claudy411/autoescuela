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

import com.mongodb.autoescuela.model.Profesor;
import com.mongodb.autoescuela.service.ProfesorService;

@CrossOrigin
@RestController
@RequestMapping("/api/roan/profesores")
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
	public ResponseEntity<Profesor> actualizar(@RequestBody Profesor profesor,@PathVariable String id) {
		Profesor profesorBd = service.listarProfesorId(id);
		if(profesorBd !=null)
		{
			Profesor actualizado=service.guardarProfesor(profesor);
			return new ResponseEntity<Profesor>(actualizado,HttpStatus.CREATED);
		}		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	// Métodos para tratar la lista de alumnos
	
	

}
