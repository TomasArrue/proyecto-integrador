package com.digitalHouse.proyectoIntegrador.dto;

import com.digitalHouse.proyectoIntegrador.model.Odontologo;
import com.digitalHouse.proyectoIntegrador.model.Paciente;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TurnoDto {
    private Long id;
    private Paciente paciente;
    private Odontologo odontologo;
    private String fecha;
}
