package com.digitalHouse.proyectoIntegrador.controller;

import com.digitalHouse.proyectoIntegrador.dto.TurnoDto;
import com.digitalHouse.proyectoIntegrador.service.ITurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService turnoService;

    private static final Logger logger = Logger.getLogger(TurnoController.class);


    @PostMapping
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDto turnoDto){
        turnoService.crearTurno(turnoDto);
        logger.info("Se creó un turno para el cliente "+turnoDto.getPaciente()+" con el odontologo "+turnoDto.getOdontologo()+" exitosamente");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TurnoDto mostrarTurno(@PathVariable Long id){
        return turnoService.leerTurno(id);
    }

    @GetMapping
    public Collection<TurnoDto> getTodasCursadas(){
        return turnoService.getTodos();
    }

    @PutMapping
    public ResponseEntity<?> modificarTruno(@RequestBody TurnoDto turnoDto){
        turnoService.modificarTurno(turnoDto);
        logger.info("Se modificó el turno "+turnoDto.getId()+"del paciente "+turnoDto.getPaciente()+" exitosamente");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id){
        turnoService.eliminarTurno(id);
        logger.info("Se eliminó el turno con id "+id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
