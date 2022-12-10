package com.digitalHouse.proyectoIntegrador.repository;

import com.digitalHouse.proyectoIntegrador.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
