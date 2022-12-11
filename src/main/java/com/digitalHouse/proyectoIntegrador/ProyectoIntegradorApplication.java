package com.digitalHouse.proyectoIntegrador;

import com.digitalHouse.proyectoIntegrador.dto.PacienteDto;
import com.digitalHouse.proyectoIntegrador.service.impl.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoIntegradorApplication {
	//public static final Logger logger = Logger.getLogger(ProyectoIntegradorApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProyectoIntegradorApplication.class, args);

	}

}
