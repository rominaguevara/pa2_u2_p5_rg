package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroRepository {
	// CRUD
	public void insertar(Libro libro);

	public Libro seleccionar(Integer id);

	public void actualizar(Libro libro);

	public void eliminar(Integer id);
	
	public void insertar(Libro2 libro2);
	
	public Libro seleccionarPorNombre(String nombre);
}
