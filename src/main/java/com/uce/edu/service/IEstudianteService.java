package com.uce.edu.service;

import com.uce.edu.repository.modelo.Estudiante;

public interface IEstudianteService {
	// CRUD
	public Estudiante buscar(Integer id);

	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(Integer id);
}
