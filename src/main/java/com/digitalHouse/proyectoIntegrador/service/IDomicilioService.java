package com.digitalHouse.proyectoIntegrador.service;

import com.digitalHouse.proyectoIntegrador.dto.DomicilioDto;

import java.util.Set;

public interface IDomicilioService {

    void crearDomicilio(DomicilioDto domicilioDTO);
    DomicilioDto leerDomicilio(Long id);
    void modificarDomicilio(DomicilioDto domicilioDTO);
    void eliminarDomicilio(Long id);
    Set<DomicilioDto> getTodos();
}
