package com.mongodb.autoescuela.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(value  = "alumnos")
@Data
public class Alumno {
	
	@Id
	private String id;
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String email;
	private String permiso;	
	private Profesor profesor;
	private Boolean aprobado = false;
//	private Integer clasesDisponibles;
//	private Integer clasesDadas;
	
}
