package com.digitalHouse.proyectoIntegrador.service;

import com.digitalHouse.proyectoIntegrador.dto.OdontologoDto;
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
class OdontologoServiceTest {

    @Autowired
    IOdontologoService odontologoService;

    @Test
    @Order(1)
    public void testCrearOdontologo(){
        OdontologoDto odontologoDto = new OdontologoDto();
        odontologoDto.setId(666L);
        odontologoDto.setNombre("Juan Carlos");
        odontologoDto.setApellido("Perez");
        odontologoDto.setMatricula("555");

        odontologoService.crearOdontologo(odontologoDto);

        OdontologoDto odontologoJuan = odontologoService.leerOdontologo(666L);
        assertTrue(odontologoJuan!= null);
    }

    @Test
    @Order(2)
    public void testLeerOdonotologo(){
        OdontologoDto odontologoDto = new OdontologoDto();
        odontologoDto = odontologoService.leerOdontologo(666L);
        assertTrue(odontologoDto!= null);
    }


    @Test
    @Order(3)
    public void testModificarOdontologo(){
        OdontologoDto odontologoDto = new OdontologoDto();
        odontologoDto = odontologoService.leerOdontologo(666L);
        odontologoDto.setMatricula("444");
        odontologoService.modificarOdontologo(odontologoDto);
        odontologoDto = odontologoService.leerOdontologo(666L);
        assertTrue(odontologoDto.getMatricula() != "555");
    }

    @Test
    @Order(4)
    public void testEliminarOdonotologo(){
        OdontologoDto odontologoDto = new OdontologoDto();
        odontologoService.eliminarOdontologo(666L);
        odontologoDto = odontologoService.leerOdontologo(666L);
        assertNull(odontologoDto);
    }

}