package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IHabitacionService;
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
	// 2.Native (es usar el SQLnativo del SQL, el mismo que ejecuto en la base de
	// datos)
	// este uso cuando quiero que el rendimiento prevalesca ante la orientación a
	// objetos
	// 3.Criteria API
	// ya que el SQL se construye utilizando métodos

	@Autowired
	private ILibroService iLibroService;
	
	@Autowired
	private IHabitacionService iHabitacionService;

	@Autowired
	private IEmpleadoService iEmpleadoService;
	
	@Autowired
	private IEstudianteService iEstudianteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5RgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// Criteria API Query

		Libro libro1 = this.iLibroService.buscarPorEditorial2("Norma");
		System.out.println(libro1);
	
		Habitacion hab = this.iHabitacionService.buscarPorClase("Duplex");
		System.out.println(hab);
		
		Empleado empl = this.iEmpleadoService.buscarPorSalario("gerente", new BigDecimal(600));
		System.out.println(empl);
		
		Estudiante estu1 = this.iEstudianteService.buscarPorCriteria("Gabriela", "Ocaña", 15);
		System.out.println(estu1);
		
		Estudiante estu2 = this.iEstudianteService.buscarPorCriteriaAndOr("Tamara", "Parra", "decimo", 17);
		System.out.println(estu2);
		
		
	}
}
