package com.mongodb.autoescuela.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value="profesores")
@Data
public class Profesor {
	
	@Id
	private String id;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
    private List<Alumno> listaAlumnos;
}
