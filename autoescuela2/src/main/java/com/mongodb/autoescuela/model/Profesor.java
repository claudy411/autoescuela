package com.mongodb.autoescuela.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
	private List<Alumno> listadoAlumnos;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Alumno> getListadoAlumnos() {
		return listadoAlumnos;
	}
	public void setListadoAlumnos(List<Alumno> listadoAlumnos) {
		this.listadoAlumnos = listadoAlumnos;
	}

	
}
