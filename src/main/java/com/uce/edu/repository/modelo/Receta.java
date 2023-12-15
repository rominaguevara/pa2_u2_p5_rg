package com.uce.edu.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "receta")
public class Receta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generador")
	@SequenceGenerator (name = "generador", sequenceName = "seq_receta", allocationSize = 1)
	@Column(name = "rece_id")
	private String id;
	
	@Column(name = "rece_nombre")
	private String nombre;
	
	@Column(name = "rece_porciones")
	private Integer porciones;
	
	@Column(name = "rece_precio")
	private BigDecimal precio;
	
	@Column(name = "rece_creador")
	private String creador;
	
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
	public Integer getPorciones() {
		return porciones;
	}
	public void setPorciones(Integer porciones) {
		this.porciones = porciones;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public String getCreador() {
		return creador;
	}
	public void setCreador(String creador) {
		this.creador = creador;
	}
	
	
	
}
