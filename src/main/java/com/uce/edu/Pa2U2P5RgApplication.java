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
	// 2.Native (es usar el SQLnativo del SQL, el mismo que ejecuto en la base de
	// datos)
	// este uso cuando quiero que el rendimiento prevalesca ante la orientación a
	// objetos
	// 3.Criteria API
	// ya que el SQL se construye utilizando métodos

	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5RgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// Criteria API Query

		Ciudadano ciu = this.ciudadanoService.buscarPorApellido("Rivera");
		System.out.println(ciu);

		// Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_genero,c1_0.ciud_nombre 
		//from ciudadano c1_0 where c1_0.ciud_nombre=?
		Ciudadano ciu1 = this.ciudadanoService.buscarrPorCriteria("Romina", "Guevara", "1750888404");
		System.out.println(ciu1);
		
		//Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_genero,c1_0.ciud_nombre 
		//from ciudadano c1_0 where c1_0.ciud_apellido=?
		Ciudadano ciu2 = this.ciudadanoService.buscarrPorCriteria("André", "Rivera", "0588888888");
		System.out.println(ciu2);

		//Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_genero,c1_0.ciud_nombre
		//from ciudadano c1_0 where c1_0.ciud_cedula=?
		Ciudadano ciu3 = this.ciudadanoService.buscarrPorCriteria("Romina", "Guevara", "1750888404");
		System.out.println(ciu3);
	
		//Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_genero,c1_0.ciud_nombre 
		//from ciudadano c1_0 where c1_0.ciud_nombre=? or c1_0.ciud_apellido=?
		Ciudadano ciu4 = this.ciudadanoService.buscarPorCriteriaAndOr("Romina", "Guevara", "1750888404");
		System.out.println(ciu4);
		
		
		//Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_genero,c1_0.ciud_nombre from 
		//ciudadano c1_0 where c1_0.ciud_nombre=? and c1_0.ciud_apellido=?
		Ciudadano ciu5 = this.ciudadanoService.buscarPorCriteriaAndOr("André", "Rivera", "0550888404");
		System.out.println(ciu5);
	
	
	}
}
