package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEstudianteRepository;
import com.uce.edu.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
	}

	@Override
	public Estudiante buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorApellido(apellido);
	}

	@Override
	public Estudiante buscarPorCriteria(String nombre, String apellido, Integer edad) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.selecionarPorCriteria(nombre, apellido, edad);
	}

	@Override
	public Estudiante buscarPorCriteriaAndOr(String nombre, String apellido, String grado, Integer edad) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.selecionarPorCriteriaAndOr(nombre, apellido, grado, edad);
	}

}
