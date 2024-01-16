package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5RgApplication implements CommandLineRunner {

	// 1. Query || Query cuando tengamos que elegir entre un query y un typed, es
	// mejor typed
	// 1.1 TypedQuery
	// 1.2 NamedQuery || Cuando un query es necesario ser utilizado desde varias
	// partes
	// Declarar de una manera centralizada el query y se va a reutilizar desde las
	// diferentes partes que se necesita a traves de un nombre
	//
	// Native
	// Criteria API

	@Autowired
	private ILibroService iLibroService;

	@Autowired
	private IAutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5RgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Query");
		
		List<Libro> lista = this.iLibroService.buscarPorFechaPublicacion(LocalDateTime.of(2024, 1,1,0,0));
		
		for(Libro libro : lista) {
			System.out.println(libro);
		}
		System.out.println("TypedQuery");
		
		Libro li1 = this.iLibroService.buscarPorTitulo("Programacion ");
		System.out.println(li1);
		
		List<Libro> lista1 = this.iLibroService.buscarPorFecha(LocalDateTime.of(2024, 1,2,0,0));
		for(Libro libro : lista1) {
			System.out.println(libro);
		}
		
		System.out.println("NamedQuery");
		
		Libro li2 = this.iLibroService.buscarPorTituloNamed("Programacion Web");
		
		System.out.println(li2);
		
		List<Libro> lista2 =this.iLibroService.buscarPorFechaNamed(LocalDateTime.of(2024, 1,1,0,0));
		for(Libro libro : lista2) {
			System.out.println(libro);
		}
	}
}
