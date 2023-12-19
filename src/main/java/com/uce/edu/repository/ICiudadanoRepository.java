package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;

public interface ICiudadanoRepository {
	//CRUD
	public void insertar(Ciudadano ciudadano);
	
	public Ciudadano seleccionar(Integer id);
}
