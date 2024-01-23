package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	// CRUD
	public Estudiante seleccionar(Integer id);

	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(Integer id);
	
	public Estudiante seleccionarPorApellido(String apellido);
	
	public Estudiante selecionarPorCriteria(String nombre, String apellido, Integer edad);
	
	public Estudiante selecionarPorCriteriaAndOr(String nombre, String apellido, String grado, Integer edad);
}
