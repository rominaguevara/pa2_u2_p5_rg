package com.uce.edu.repository.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pasaporte")
public class Pasaporte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generador")
	@SequenceGenerator (name = "generador", sequenceName = "seq_pasaporte", allocationSize = 1)
	@Column(name = "pasa_id")
	private String id;
	
	@Column(name = "pasa_pais")
	private String pais;
	
	@Column(name = "pasa_nombre")
	private String nombre;
	
	@Column(name = "pasa_fechaEmision")
	private LocalDate fechaEmision;
	
	@Column(name = "pasa_fechaVencimiento")
	private LocalDate fechaVencimiento;
	
	
	//GETTERS Y SETTERS
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(LocalDate fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
	
}
