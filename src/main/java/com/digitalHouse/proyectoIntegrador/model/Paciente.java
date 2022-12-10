package com.digitalHouse.proyectoIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    //@GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private String DNI;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> turnos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id")
    private Domicilio domicilio;
}