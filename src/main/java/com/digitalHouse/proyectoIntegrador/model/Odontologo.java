package com.digitalHouse.proyectoIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "odontologos")
public class Odontologo {

    @Id
    //@GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore
    private Set<Turno> turnos;
}
