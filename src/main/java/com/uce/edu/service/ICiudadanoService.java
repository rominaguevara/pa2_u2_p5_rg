package com.uce.edu.service;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoService {
	// CRUD
	public void guardar(Ciudadano ciudadano);

	public Ciudadano buscar(Integer id);

	public void actualizar(Ciudadano ciudadano);

	public void eliminar(Integer id);

	public Empleado buscarPorCedula(String cedula);
	
	public Ciudadano bucarPorCedulaCiu(String cedula);
}
