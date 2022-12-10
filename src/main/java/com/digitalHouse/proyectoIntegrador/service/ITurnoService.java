package com.digitalHouse.proyectoIntegrador.service;

import com.digitalHouse.proyectoIntegrador.dto.TurnoDto;
import java.util.Set;

public interface ITurnoService {

    void crearTurno(TurnoDto turnoDTO);
    TurnoDto leerTurno(Long id);
    void modificarTurno(TurnoDto turnoDTO);
    void eliminarTurno(Long id);
    Set<TurnoDto> getTodos();
}
