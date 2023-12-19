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

		Ciudadano ciud1 = new Ciudadano();
	
		ciud1.setNombre("Romina");
		ciud1.setApellido("Guevara");
		
		this.iciudadanoService.guardar(ciud1);
		
		Empleado empl1 = new Empleado();
		empl1.setFechaIngreso(LocalDateTime.now());
		empl1.setSalario(new BigDecimal(2000));
		
		
		Ciudadano ciud2 =this.iciudadanoService.buscar(1); 
		
		empl1.setCiudadano(ciud2);
		
		this.iEmpleadoService.guardar(empl1);
		
	}

}
