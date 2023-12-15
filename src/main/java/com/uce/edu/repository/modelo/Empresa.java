package com.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generador")
	@SequenceGenerator (name = "generador", sequenceName = "seq_empresa", allocationSize = 1)
	@Column(name = "empr_id")
	private String id;
	
	@Column(name = "empr_nombre")
	private String nombre;
	
	@Column(name = "empr_empleados")
	private Integer empleados;
	
	@Column(name = "empr_direccion")
	private String direccion;
	
	@Column(name = "empr_accionistas")
	private Integer accionistas;
	
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
	public Integer getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Integer empleados) {
		this.empleados = empleados;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getAccionistas() {
		return accionistas;
	}
	public void setAccionistas(Integer accionistas) {
		this.accionistas = accionistas;
	}
	
	
	
}
