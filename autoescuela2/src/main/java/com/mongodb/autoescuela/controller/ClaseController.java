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

import com.mongodb.autoescuela.model.Clase;
import com.mongodb.autoescuela.service.ClaseService;


@CrossOrigin
@RestController
@RequestMapping("/api/roan/clases")
public class ClaseController {
	
	@Autowired
	private ClaseService service;
	
	@PostMapping
	public ResponseEntity<Clase> guardarClase(@RequestBody Clase clase){
		Clase claseBd=service.guardarClase(clase);
		return new ResponseEntity<Clase>(claseBd,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Clase>> listarTodasClases(){
		List<Clase> listarClases=service.listarTodasClases();
		return new ResponseEntity<List<Clase>>(listarClases,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clase> listarClaseId(@PathVariable String id){
		Clase claseBd=service.listarClaseId(id);
		return new ResponseEntity<Clase>(claseBd,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarClaseId(@PathVariable String id){
		service.eliminarClase(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Clase> actualizar(@RequestBody Clase clase,@PathVariable String id) {
		Clase claseBd = service.listarClaseId(id);
		if(claseBd !=null)
		{
			Clase actualizado=service.guardarClase(clase);
			return new ResponseEntity<Clase>(actualizado,HttpStatus.CREATED);
		}		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
