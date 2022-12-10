package com.digitalHouse.proyectoIntegrador.service;

import com.digitalHouse.proyectoIntegrador.dto.DomicilioDto;
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
class DomicilioServiceTest {

    @Autowired
    IDomicilioService domicilioService;

    @Test
    @Order(1)
    public void testCrearDomicilio(){
        DomicilioDto domicilioDto = new DomicilioDto();
        domicilioDto.setId(666L);
        domicilioDto.setCalle("Av de Mayo");
        domicilioDto.setNumero(1456);

        domicilioService.crearDomicilio(domicilioDto);

        DomicilioDto domicilioDTONuevo = domicilioService.leerDomicilio(666L);
        assertTrue(domicilioDTONuevo!= null);
    }

    @Test
    @Order(2)
    public void testLeerDomicilio(){
        DomicilioDto domicilioDto = new DomicilioDto();
        domicilioDto = domicilioService.leerDomicilio(666L);
        assertTrue(domicilioDto!= null);
    }


    @Test
    @Order(3)
    public void testModificarDomicilio(){
        DomicilioDto domicilioDto = new DomicilioDto();
        domicilioDto = domicilioService.leerDomicilio(666L);
        domicilioDto.setNumero(1540);
        domicilioService.modificarDomicilio(domicilioDto);
        domicilioDto = domicilioService.leerDomicilio(666L);
        assertTrue(domicilioDto.getNumero() != 1456);
    }

    @Test
    @Order(4)
    public void testEliminarDomicilio(){
        DomicilioDto domicilioDto = new DomicilioDto();
        domicilioService.eliminarDomicilio(666L);
        domicilioDto = domicilioService.leerDomicilio(666L);
        assertNull(domicilioDto);
    }

}