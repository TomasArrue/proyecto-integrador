package com.digitalHouse.proyectoIntegrador.service.impl;

import com.digitalHouse.proyectoIntegrador.dto.TurnoDto;
import com.digitalHouse.proyectoIntegrador.model.Turno;
import com.digitalHouse.proyectoIntegrador.repository.ITurnoRepository;
import com.digitalHouse.proyectoIntegrador.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarTurno(TurnoDto turnoDto){
        Turno turno = mapper.convertValue(turnoDto, Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public void crearTurno(TurnoDto turnoDto) {
        guardarTurno(turnoDto);
    }

    @Override
    public TurnoDto leerTurno(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDto turnoDto = null;
        if(turno.isPresent()){
            turnoDto = mapper.convertValue(turno, TurnoDto.class);
        }
        return turnoDto;    }

    @Override
    public void modificarTurno(TurnoDto turnoDto) {
        guardarTurno(turnoDto);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Set<TurnoDto> getTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDto> turnosDto = new HashSet<>();

        for (Turno turno: turnos){
            turnosDto.add(mapper.convertValue(turno, TurnoDto.class));
        }
        return turnosDto;    }
}
