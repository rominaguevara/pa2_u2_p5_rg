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
	
	public Ciudadano selecionarPorApellido(String apellido);
	
	public Ciudadano selecionarPorGenero(String genero);

}
