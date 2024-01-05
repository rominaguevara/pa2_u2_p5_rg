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

		Ciudadano ciuda1 = new Ciudadano();
	
		ciuda1.setNombre("Romina");
		ciuda1.setApellido("Guevara");
		
		this.iciudadanoService.guardar(ciuda1);
		
		Empleado emple1 = new Empleado();
		emple1.setFechaIngreso(LocalDateTime.now());
		emple1.setSalario(new BigDecimal(2000));
		
		Ciudadano ciuda2 =this.iciudadanoService.buscar(36); 
		
		emple1.setCiudadano(ciuda2);
		
		this.iEmpleadoService.guardar(emple1);
		
		
		this.iciudadanoService.eliminar(28);
		
		ciuda1.setApellido("Guevara Gaunuchi");
		this.iciudadanoService.actualizar(ciuda1);
		
		emple1.setSalario(new BigDecimal(2001));
		this.iEmpleadoService.actualizar(emple1);
		
		this.iEmpleadoService.buscar(2);
		
		this.iEmpleadoService.eliminar(23);
		
	}

}
