package com.digitalHouse.proyectoIntegrador.service;

import com.digitalHouse.proyectoIntegrador.dto.OdontologoDto;
import com.digitalHouse.proyectoIntegrador.dto.PacienteDto;
import com.digitalHouse.proyectoIntegrador.dto.TurnoDto;
import com.digitalHouse.proyectoIntegrador.model.Odontologo;
import com.digitalHouse.proyectoIntegrador.model.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TurnoServiceTest {

    @Autowired
    ITurnoService turnoService;
    @Autowired
    IPacienteService pacienteService;
    @Autowired
    IOdontologoService odontologoService;
    @Autowired
    ObjectMapper mapper;

    @Test
    @Order(1)
    public void testCrearTurno(){
        TurnoDto turnoDto = new TurnoDto();
        turnoDto.setId(666L);
        turnoDto.setFecha("30/03/2023");


        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto.setId(666L);
        pacienteDto.setNombre("Juan Carlos");
        pacienteDto.setApellido("Perez");
        pacienteDto.setDNI("41473521");

        pacienteService.crearPaciente(pacienteDto);

        pacienteDto =  pacienteService.leerPaciente(666L);
        Paciente paciente = mapper.convertValue(pacienteDto, Paciente.class);
        turnoDto.setPaciente(paciente);

        OdontologoDto odontologoDto = new OdontologoDto();
        odontologoDto.setId(666L);
        odontologoDto.setNombre("Juan Carlos");
        odontologoDto.setApellido("Perez");
        odontologoDto.setMatricula("555");

        odontologoService.crearOdontologo(odontologoDto);

        odontologoDto = odontologoService.leerOdontologo(666L);
        Odontologo odontologo = mapper.convertValue(odontologoDto, Odontologo.class);
        turnoDto.setOdontologo(odontologo);

        turnoService.crearTurno(turnoDto);

        TurnoDto turnoNuevo = turnoService.leerTurno(666L);
        assertTrue(turnoNuevo!= null);
    }

    @Test
    @Order(2)
    public void testLeerTurno(){
        TurnoDto turnoDto = new TurnoDto();
        turnoDto = turnoService.leerTurno(666L);
        assertTrue(turnoDto!= null);
    }

    @Test
    @Order(3)
    public void testModificarTruno(){
        TurnoDto turnoDto = new TurnoDto();
        turnoDto = turnoService.leerTurno(666L);
        turnoDto.setFecha("30/03/2024");
        turnoService.modificarTurno(turnoDto);
        turnoDto = turnoService.leerTurno(666L);
        assertTrue(turnoDto.getFecha() != "30/03/2023");
    }

    @Test
    @Order(4)
    public void testEliminarTurno(){
        TurnoDto turnoDto = new TurnoDto();
        turnoService.eliminarTurno(666L);
        turnoDto = turnoService.leerTurno(666L);
        assertNull(turnoDto);
    }
}