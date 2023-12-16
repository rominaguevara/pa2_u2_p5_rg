package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5RgApplication implements CommandLineRunner {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IAlumnoService alumnoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5RgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// Crear estudiante

		Estudiante estudiante = new Estudiante();
		// estudiante.setNombre("Andrea");
		// estudiante.setApellido("Guevara");
		// estudiante.setCedula("1750888321");
		// estudiante.setFechaNacimiento(LocalDateTime.of(2006, 10, 13, 20, 15));

		// 1.-guardar o insertar
		// this.estudianteService.guardar(estudiante);

		// buscar estudiante
		// Estudiante estu1 = this.estudianteService.buscar(34);
		// System.out.println(estu1);

		// eliminar estudiante
		// this.estudianteService.eliminar(31);

		// actualizar estudiante
		// estudiante.setNombre("Romina Mishell");
		// this.estudianteService.actualizar(estudiante);

		// Crear Alumno
		Alumno alum1 = new Alumno();
		// alum1.setNombre("Annnnnnnn");

		// guardar alumno
		// this.alumnoService.guardar(alum1);

		// buscar alumno
		Alumno busca = this.alumnoService.buscar(4);
		System.out.println(busca);

		// eliminar alumno
		// this.alumnoService.eliminar(5);

		// actualizar alumno
		// alum1.setNombre("Ana");
		// this.alumnoService.actualizar(alum1);

	}

}
