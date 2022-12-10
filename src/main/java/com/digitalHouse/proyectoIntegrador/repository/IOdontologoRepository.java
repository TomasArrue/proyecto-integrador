package com.digitalHouse.proyectoIntegrador.repository;

import com.digitalHouse.proyectoIntegrador.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {
}
