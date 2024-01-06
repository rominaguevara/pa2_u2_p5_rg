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
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ILibroService;


@SpringBootApplication
public class Pa2U2P5RgApplication implements CommandLineRunner {

	@Autowired
	private ILibroService libroService;
	
	@Autowired
	private IAutorService autorService;
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5RgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//LIBRO CON VARIOS AUTORES
		Libro libro1 = new Libro();
		libro1.setTitulo("Foto Estudio Corazon");
		libro1.setFechaPublicacion(LocalDateTime.now());
		
		
		Autor au1 = new Autor();
		au1.setNombre("Julio Verne");
		au1.setNacionalidad("Alemano");
		
		
		Autor au2 = new Autor();
		au2.setNombre("Maria Heredia");
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
				
		au1.setNombre("Maria Fernanda Heredia");
		this.autorService.actualizar(au1);
		
		this.autorService.buscar(1);
		
		this.autorService.eliminar(3);
		
		//AUTOR CON VARIOS LIBROS
		Autor autor3 = new Autor();
		autor3.setNombre("Julio Verne");
		autor3.setNacionalidad("Francia");
		
		Libro libro2 = new Libro();
		libro2.setTitulo("20 mil leguas de Viaje Submarino");
		libro2.setFechaPublicacion(LocalDateTime.of(1869, 03, 20, 0, 0));
		
		Libro libro3 = new Libro();
		libro3.setTitulo("Viaje al centro de la Tierra");
		libro3.setFechaPublicacion(LocalDateTime.of(1864, 11, 25, 0, 0));
		
		autores.add(autor3);
		libros.add(libro2);
		libros.add(libro3);
		
		this.autorService.guardar(autor3);
		
		autor3.setNombre("Jules Gabriel Verne");
		this.autorService.actualizar(autor3);
		
		this.autorService.buscar(4);
		
		this.autorService.eliminar(6);
		
		
		
		
	}

}
