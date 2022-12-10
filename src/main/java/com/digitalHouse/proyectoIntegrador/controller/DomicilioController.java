package com.digitalHouse.proyectoIntegrador.controller;

import com.digitalHouse.proyectoIntegrador.dto.DomicilioDto;
import com.digitalHouse.proyectoIntegrador.service.IDomicilioService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    IDomicilioService domicilioService;

    private static final Logger logger = Logger.getLogger(DomicilioController.class);

    @PostMapping
    public ResponseEntity<?> crearDomicilio(@RequestBody DomicilioDto domicilioDto){
        domicilioService.crearDomicilio(domicilioDto);
        logger.info("Se creó un domicilio exitosamente");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DomicilioDto mostrarDomicilio(@PathVariable Long id){
        return domicilioService.leerDomicilio(id);
    }

    @GetMapping
    public Collection<DomicilioDto> getTodosDomicilios(){
        return domicilioService.getTodos();
    }

    @PutMapping
    public ResponseEntity<?> modificarDomicilio(@RequestBody DomicilioDto domicilioDto){
        domicilioService.modificarDomicilio(domicilioDto);
        logger.info("Se modificó al domicilio con id "+domicilioDto.getId()+" exitosamente");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id){
        domicilioService.eliminarDomicilio(id);
        logger.info("Se modificó al domicilio con id "+id+" exitosamente");
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
