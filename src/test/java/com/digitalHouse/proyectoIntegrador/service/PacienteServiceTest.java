package com.digitalHouse.proyectoIntegrador.service;

import static org.junit.jupiter.api.Assertions.*;
import com.digitalHouse.proyectoIntegrador.dto.PacienteDto;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class PacienteServiceTest {
    @Autowired
    IPacienteService pacienteService;

    @Test
    @Order(1)
    public void testCrearPaciente(){
        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto.setId(666L);
        pacienteDto.setNombre("Juan Carlos");
        pacienteDto.setApellido("Perez");
        pacienteDto.setDNI("41473521");

        pacienteService.crearPaciente(pacienteDto);

        PacienteDto pacienteJuan = pacienteService.leerPaciente(666L);
        assertTrue(pacienteJuan!= null);
    }

    @Test
    @Order(2)
    public void testLeerPaciente(){
        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto = pacienteService.leerPaciente(666L);
        assertTrue(pacienteDto!= null);
    }


    @Test
    @Order(3)
    public void testModificarPAciente(){
        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto = pacienteService.leerPaciente(666L);
        pacienteDto.setDNI("41473520");
        pacienteService.modificarPaciente(pacienteDto);
        pacienteDto = pacienteService.leerPaciente(666L);
        assertTrue(pacienteDto.getDNI() != "41473521");
    }

    @Test
    @Order(4)
    public void testEliminarPAciente(){
        PacienteDto pacienteDto = new PacienteDto();
        pacienteService.eliminarPaciente(666L);
        pacienteDto = pacienteService.leerPaciente(666L);
        assertNull(pacienteDto);
    }
}