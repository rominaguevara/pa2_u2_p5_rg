package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ILibroRepository;
import com.uce.edu.repository.modelo.Libro;
@Service
public class LibroServiceImpl implements ILibroService {

	@Autowired
	private ILibroRepository LibroRepository;
	
	@Override
	public void guardar(Libro libro) {
		// TODO Auto-generated method stub
		this.LibroRepository.insertar(libro);
	}

	@Override
	public Libro buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Libro libro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub

	}

}
