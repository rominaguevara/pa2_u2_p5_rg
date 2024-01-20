package com.uce.edu.service;

import com.uce.edu.repository.modelo.Alumno;

public interface IAlumnoService {
	// CRUD
	public Alumno buscar(Integer id);

	public void guardar(Alumno alumno);

	public void actualizar(Alumno alumno);

	public void eliminar(Integer id);

	public Alumno buscarPorNombre(String nombre);
}
