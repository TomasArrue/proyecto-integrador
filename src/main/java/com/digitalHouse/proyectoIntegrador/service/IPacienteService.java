package com.digitalHouse.proyectoIntegrador.service;

import com.digitalHouse.proyectoIntegrador.dto.PacienteDto;
import java.util.Set;

public interface IPacienteService {

    void crearPaciente(PacienteDto pacienteDTO);
    PacienteDto leerPaciente(Long id);
    void modificarPaciente(PacienteDto pacienteDTO);
    void eliminarPaciente(Long id);
    Set<PacienteDto> getTodos();
}
