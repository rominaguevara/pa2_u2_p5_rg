package com.uce.edu;

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

	@Autowired
	private ICiudadanoService iciudadanoService;

	@Autowired
	private IEmpleadoService iEmpleadoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5RgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Empleado empleadoDos = new Empleado();
		
		empleadoDos.setFechaIngreso(LocalDateTime.now());
		
		Ciudadano ciudadanoDos = new Ciudadano();
		
		ciudadanoDos.setNombre("Cecilia");
		ciudadanoDos.setApellido("Arcos");
				
		ciudadanoDos.setEmpleado(empleadoDos);
		
		empleadoDos.setCiudadano(ciudadanoDos);
		
		this.iciudadanoService.guardar(ciudadanoDos);

	}

}
