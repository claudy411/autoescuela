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

import com.mongodb.autoescuela.model.Alumno;
import com.mongodb.autoescuela.service.AlumnoService;

@CrossOrigin
@RestController
@RequestMapping("/api/roan/alumnos")

public class AlumnoController {
	
	@Autowired
	private  AlumnoService service;
	
	@PostMapping
	public ResponseEntity<Alumno> guardarAlumno(@RequestBody Alumno alumno) {
		Alumno alumnoBd = service.guardarAlumno(alumno);
		return new ResponseEntity<Alumno>(alumnoBd,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Alumno>> listarTodos(){
		 List<Alumno> listarTodoAlumnos = service.listarTodos();
		 return new ResponseEntity<List<Alumno>>(listarTodoAlumnos,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> listarPorId(@PathVariable String id) {
		Alumno alumnoBd = service.listarPorId(id);
		return new ResponseEntity<Alumno>(alumnoBd,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarAlumno(@PathVariable String id) {
		service.eliminarAlumno(id); 
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Alumno> actualizar(@RequestBody Alumno alumno,@PathVariable String id) {
		Alumno alumnoBd = service.listarPorId(id);

		if(alumnoBd !=null)
		{
			Alumno actualizado=service.guardarAlumno(alumno);
			return new ResponseEntity<Alumno>(actualizado,HttpStatus.CREATED);
		}		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
