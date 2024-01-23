package com.uce.edu.service;

import com.uce.edu.repository.modelo.Estudiante;

public interface IEstudianteService {
	// CRUD
	public Estudiante buscar(Integer id);

	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(Integer id);

	public Estudiante buscarPorApellido(String apellido);

	public Estudiante buscarPorCriteria(String nombre, String apellido, Integer edad);

	public Estudiante buscarPorCriteriaAndOr(String nombre, String apellido, String grado, Integer edad);
}
