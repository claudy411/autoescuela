package com.mongodb.autoescuela.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value="clases")
@Data
public class Clase {
	
	@Id
	private String id;
	private LocalDate fecha;
	private String hora;
	private Alumno alumno;

}
