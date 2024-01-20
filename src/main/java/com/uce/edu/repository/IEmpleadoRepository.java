package com.uce.edu.repository;

import java.math.BigDecimal;

import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoRepository {
	// CRUD
	public void insertar(Empleado empleado);

	public Empleado seleccionar(Integer id);

	public void actualizar(Empleado empleado);

	public void eliminar(Integer id);
	
	public Empleado selecionarPorPuesto(String puesto);
	
	public Empleado seleccionarPorSalario(BigDecimal salario);

}
