package com.uce.edu.service;

import java.math.BigDecimal;

import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoService {
	// CRUD
	public void guardar(Empleado empleado);

	public Empleado buscar(Integer id);

	public void actualizar(Empleado empleado);

	public void eliminar(Integer id);

	public Empleado buscarPorPuesto(String puesto);
	
	public Empleado buscarPorSalario(BigDecimal salario);
}
