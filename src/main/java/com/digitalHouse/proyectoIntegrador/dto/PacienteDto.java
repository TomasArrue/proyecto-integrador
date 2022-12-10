package com.digitalHouse.proyectoIntegrador.dto;

import com.digitalHouse.proyectoIntegrador.model.Domicilio;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String DNI;
    private Domicilio domicilio;
}
