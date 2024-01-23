package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IHotelService;
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
	// 2.Native (es usar el SQLnativo del SQL, el mismo que ejecuto en la base de datos)
	//	este uso cuando quiero que el rendimiento prevalesca ante la orientación a objetos
	// 3.Criteria API

	@Autowired
	private ICiudadanoService ciudadanoService;
	
	@Autowired
	private IEmpleadoService empleadoService;

	@Autowired
	private IAlumnoService iAlumnoService;
	
	@Autowired
	private IAutorService iAutorService;
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private ILibroService iLibroService;

	@Autowired
	private IHotelService iHotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5RgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		System.out.println("------------------------------------------");
		System.out.println("TYPED");
		System.out.println("------------------------------------------");
		
		Alumno alum = this.iAlumnoService.buscarPorNombre("Luis");
		System.out.println(alum);
		
		Autor aut = this.iAutorService.buscarPorNacionalidad("Francia");
		System.out.println(aut);
		
		Ciudadano ciud = this.ciudadanoService.buscarPorApellido("Rivera");
		System.out.println(ciud);
		
		Estudiante estu = this.estudianteService.buscarPorApellido("Rodriguez");
		System.out.println(estu);
		
		Libro lib = this.iLibroService.buscarEditorial("Norma");
		System.out.println(lib);
				
		System.out.println("------------------------------------------");
		System.out.println("NATIVE");
		System.out.println("------------------------------------------");
		
		Hotel hot = this.iHotelService.buscarPorDireccion("Colon");
		System.out.println(hot);
		
		Ciudadano ciuda = this.ciudadanoService.buscarPorGenero("femenino");
		System.out.println(ciuda);

		Empleado emple = this.empleadoService.buscarPorPuesto("gerente");
		System.out.println(emple);
		
		Empleado emplea = this.empleadoService.buscarPorSalario(new BigDecimal(1500));
		System.out.println(emplea);
		
		Libro libro = this.iLibroService.buscarEdicion(1);
		System.out.println(libro);
		System.out.println("\n");
		
		
	}
}
