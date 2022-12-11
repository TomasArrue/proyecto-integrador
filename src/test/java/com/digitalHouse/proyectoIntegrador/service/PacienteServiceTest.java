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
        pacienteDto.setId(999L);
        pacienteDto.setNombre("Pepe");
        pacienteDto.setApellido("Gomez");
        pacienteDto.setDni("1234567");

        pacienteService.crearPaciente(pacienteDto);

        PacienteDto pacienteJuan = pacienteService.leerPaciente(999L);
        assertTrue(pacienteJuan!= null);
    }

    @Test
    @Order(2)
    public void testLeerPaciente(){
        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto = pacienteService.leerPaciente(999L);
        assertTrue(pacienteDto!= null);
    }


    @Test
    @Order(3)
    public void testModificarPaciente(){
        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto = pacienteService.leerPaciente(999L);
        pacienteDto.setDni("7654321");
        pacienteService.modificarPaciente(pacienteDto);
        pacienteDto = pacienteService.leerPaciente(999L);
        assertTrue(pacienteDto.getDni() == "7654321");
    }

    @Test
    @Order(4)
    public void testEliminarPaciente(){
        PacienteDto pacienteDto = new PacienteDto();
        pacienteService.eliminarPaciente(999L);
        pacienteDto = pacienteService.leerPaciente(999L);
        assertNull(pacienteDto);
    }
}