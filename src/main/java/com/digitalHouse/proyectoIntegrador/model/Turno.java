package com.digitalHouse.proyectoIntegrador.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    //@GeneratedValue
    private Long id;
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;
}