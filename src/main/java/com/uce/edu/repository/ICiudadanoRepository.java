package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoRepository {
	// CRUD
	public void insertar(Ciudadano ciudadano);

	public Ciudadano seleccionar(Integer id);

	public void actualizar(Ciudadano ciudadano);

	public void eliminar(Integer id);

	public Empleado seleccionarporCedula(String cedula);
	
	public Ciudadano selecionarPorCedulaCiu(String cedula);
		
	public Ciudadano selecionarPorGenero(String genero);
	
	public Ciudadano selecionarPorApellido(String apellido);
	
	//Funcionalidad que cuando sea el ciudadano de Pichincha lo busque por nombre
	//Cuando seaa de Cotopaxi lo busque por apellido
	//Cuando no sea ni de Cotopaxi ni de Pichincha lo busque por cedula 
	public Ciudadano selecionarPorCriteria(String nombre, String apellido, String cedula);
	
	public Ciudadano selecionarPorCriteriaAndOr(String nombre, String apellido, String cedula);
}
