package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;

@SpringBootApplication
public class Pa2U2P5RgApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IHabitacionService habitacionService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5RgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Hotel hotel = new Hotel();
		hotel.setDireccion("Colon");
		hotel.setNombre("Marriot");
		
		Habitacion h1 = new Habitacion();
		h1.setClase("Economica");
		h1.setNumero("A1");
		h1.setHotel(hotel);
		
		
		Habitacion h2 = new Habitacion();
		h2.setClase("Presidencial");
		h2.setNumero("A2");
		h2.setHotel(hotel);
		
		List<Habitacion> habitaciones = new ArrayList<>();
		habitaciones.add(h1);
		habitaciones.add(h2);
		
		hotel.setHabitaciones(habitaciones);
		
		this.hotelService.guardar(hotel);
		
		Hotel hot = this.hotelService.buscar(2);
		System.out.println(hot);
		
		Habitacion hab = this.habitacionService.buscar(6);
		System.out.println(hab);
		
		hotel.setNombre("Hilton");
		this.hotelService.actualizar(hotel);
		
		h1.setClase("Economica-Simple");
		this.habitacionService.actualizar(h1);
		
		this.habitacionService.eliminar(8);
		this.hotelService.eliminar(2);
	}

}
