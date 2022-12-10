package com.digitalHouse.proyectoIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "domicilios")
public class Domicilio {
    @Id
    //@GeneratedValue
    private Long id;
    private String calle;
    private Integer numero;

    @OneToOne(mappedBy = "domicilio")
    @JsonIgnore
    private Paciente paciente;

    //Completar los campos porque sinó no corre, mismo el DTO
}