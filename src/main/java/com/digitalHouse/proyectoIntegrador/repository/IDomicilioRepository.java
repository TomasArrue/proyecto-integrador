package com.digitalHouse.proyectoIntegrador.repository;

import com.digitalHouse.proyectoIntegrador.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio, Long> {

}
