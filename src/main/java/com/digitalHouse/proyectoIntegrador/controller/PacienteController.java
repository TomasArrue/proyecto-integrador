package com.digitalHouse.proyectoIntegrador.controller;

import com.digitalHouse.proyectoIntegrador.dto.PacienteDto;
import com.digitalHouse.proyectoIntegrador.service.IPacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    private static final Logger logger = Logger.getLogger("Capa Controller: " + PacienteController.class);

    @PostMapping
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDto pacienteDto){
        logger.info("Inicia creacion de paciente");
        pacienteService.crearPaciente(pacienteDto);
        logger.info("Se creó un paciente exitosamente");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDto mostrarPaciente(@PathVariable Long id){
        return pacienteService.leerPaciente(id);
    }

    @GetMapping
    public Collection<PacienteDto> getTodosPacientes(){
        return pacienteService.getTodos();
    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDto pacienteDto){
        pacienteService.modificarPaciente(pacienteDto);
        logger.info("Se modificó al paciente "+pacienteDto.getNombre()+" "+pacienteDto.getApellido()+" exitosamente");
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id){
        pacienteService.eliminarPaciente(id);
        logger.info("Se eliminó el paciente con id "+id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

//    public ResponseEntity<PacienteDTO> verificarCorreo(@PathVariable PacienteDTO pacienteDTO) {
//        if (pacienteDTO.) {
//            return new ResponseEntity<>("Formato debe ser: ejemplo@correo.dominio", HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(pacienteDTO, HttpStatus.OK);
//    }

}