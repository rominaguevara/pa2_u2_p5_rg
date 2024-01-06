package com.uce.edu;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ILibroService;


@SpringBootApplication
public class Pa2U2P5RgApplication implements CommandLineRunner {

	@Autowired
	private ILibroService libroService;
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5RgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Libro libro1 = new Libro();
		libro1.setTitulo("20 mil leguas de viaje submarino");
		libro1.setFechaPublicacion(LocalDateTime.now());
		
		
		Autor au1 = new Autor();
		au1.setNombre("Julio Verne");
		au1.setNacionalidad("Alemano");
		
		
		Autor au2 = new Autor();
		au2.setNombre("Maria Fernanda Heredia");
		au2.setNacionalidad("Ecuatoriano");
		
		
		Set<Autor> autores = new HashSet<Autor>();
		autores.add(au1);
		autores.add(au2);
		
		libro1.setAutores(autores);
		
		Set<Libro> libros = new HashSet<Libro>();
		libros.add(libro1);
		
		au1.setLibros(libros);
		au2.setLibros(libros);
		
		this.libroService.guardar(libro1);
			
	}

}
