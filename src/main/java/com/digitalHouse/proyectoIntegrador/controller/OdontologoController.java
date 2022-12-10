package com.digitalHouse.proyectoIntegrador.controller;

import com.digitalHouse.proyectoIntegrador.dto.OdontologoDto;
import com.digitalHouse.proyectoIntegrador.service.IOdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    IOdontologoService odontologoService;

    private static final Logger logger = Logger.getLogger(OdontologoController.class);


    @PostMapping
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDto odontologoDto){
        odontologoService.crearOdontologo(odontologoDto);
        logger.info("Se creó un odontologo exitosamente");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDto mostrarOdontologo(@PathVariable Long id){
        return odontologoService.leerOdontologo(id);
    }

    @GetMapping
    public Collection<OdontologoDto> getTodosOdontologos(){
        return odontologoService.getTodos();
    }

    @PutMapping
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDto odontologoDto){
        odontologoService.modificarOdontologo(odontologoDto);
        logger.info("Se modificó al odontologo "+odontologoDto.getNombre()+" "+odontologoDto.getApellido()+" exitosamente");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        odontologoService.eliminarOdontologo(id);
        logger.info("Se eliminó el odontologo con id"+id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
