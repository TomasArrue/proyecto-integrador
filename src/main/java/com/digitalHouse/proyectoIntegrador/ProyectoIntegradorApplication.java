package com.digitalHouse.proyectoIntegrador;

import com.digitalHouse.proyectoIntegrador.dto.PacienteDto;
import com.digitalHouse.proyectoIntegrador.service.impl.PacienteService;
import org.apache.log4j.chainsaw.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class ProyectoIntegradorApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProyectoIntegradorApplication.class, args);
	}

}
