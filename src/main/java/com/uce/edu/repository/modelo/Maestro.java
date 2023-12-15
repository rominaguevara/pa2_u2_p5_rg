package com.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "maestro")
public class Maestro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generador")
	@SequenceGenerator (name = "generador", sequenceName = "seq_maestro", allocationSize = 1)
	@Column(name = "maes_id")
	private String id;
	
	@Column(name = "maes_nombre")
	private String nombre;
	
	@Column(name = "maes_apellido")
	private String apellido;
	
	@Column(name = "maes_edad")
	private Integer edad;
	
	@Column(name = "maes_materia")
	private String materia;
	
	//GETTERS Y SETTERS
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
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	

}
