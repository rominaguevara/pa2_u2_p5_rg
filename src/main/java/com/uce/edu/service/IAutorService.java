package com.uce.edu.service;

import com.uce.edu.repository.modelo.Autor;

public interface IAutorService {

	// CRUD
	public Autor buscar(Integer id);

	public void guardar(Autor autor);

	public void actualizar(Autor autor);

	public void eliminar(Integer id);
	
	public Autor buscarPorNacionalidad(String nacionalidad);

}
