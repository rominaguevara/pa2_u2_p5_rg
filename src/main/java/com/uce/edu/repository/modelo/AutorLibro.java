package com.uce.edu.repository.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor2_libro2")
public class AutorLibro { //Tabla de rompimiento mapeada

	private Integer id;
	private Autor2 autor2;
	private Libro2 libro2;
	
}
