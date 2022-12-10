package com.digitalHouse.proyectoIntegrador.service;

import com.digitalHouse.proyectoIntegrador.dto.OdontologoDto;

import java.util.Set;

public interface IOdontologoService {

    void crearOdontologo(OdontologoDto odontologoDTO);
    OdontologoDto leerOdontologo(Long id);
    void modificarOdontologo(OdontologoDto odontologoDTO);
    void eliminarOdontologo(Long id);
    Set<OdontologoDto> getTodos();
}
