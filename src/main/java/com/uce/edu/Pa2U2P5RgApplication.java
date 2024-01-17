package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;

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


	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5RgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		Empleado empl = this.ciudadanoService.buscarPorCedula("1750888404");
		System.out.println(empl);

		Ciudadano ciudadano = this.ciudadanoService.bucarPorCedulaCiu("1750888404");
		System.out.println(ciudadano);
		
	}
}
