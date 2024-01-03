package com.uce.edu.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {

	// Tabla master
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hotel")
	@SequenceGenerator(name = "seq_hotel", sequenceName = "seq_hotel", allocationSize = 1)
	@Column(name = "hote_id")
	private Integer id;

	@Column(name = "hote_nombre")
	private String nombre;

	@Column(name = "hote_direccion")
	private String direccion;

	// AQUI HAGO LA VINCULACIÓN CON LAS HABITACIONES esta es una relación una a muchas PARA ELLO USO LISTA
	//la relación es de un hotel a muchas habitaciones
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)//el nombre es el con el que fue mapeado en mi otra clase esta clase es decir "hotel" que es la forma en que estoy instanciando en la clase habitación
	private List<Habitacion> habitaciones;


	// SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
}
