package com.digitalHouse.proyectoIntegrador.service.impl;

import com.digitalHouse.proyectoIntegrador.dto.OdontologoDto;
import com.digitalHouse.proyectoIntegrador.model.Odontologo;
import com.digitalHouse.proyectoIntegrador.repository.IOdontologoRepository;
import com.digitalHouse.proyectoIntegrador.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService  implements IOdontologoService {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarOdontologo(OdontologoDto odontologoDto){
        Odontologo odontologo = mapper.convertValue(odontologoDto, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public void crearOdontologo(OdontologoDto odontologoDto) { guardarOdontologo(odontologoDto);}

    @Override
    public OdontologoDto leerOdontologo(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDto odontologoDto = null;
        if(odontologo.isPresent()){
            odontologoDto = mapper.convertValue(odontologo, OdontologoDto.class);
        }
        return odontologoDto;
    }

    @Override
    public void modificarOdontologo(OdontologoDto odontologoDto) {
        guardarOdontologo(odontologoDto);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDto> getTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDto> odontologosDto = new HashSet<>();

        for (Odontologo odontologo: odontologos){
            odontologosDto.add(mapper.convertValue(odontologo, OdontologoDto.class));
        }
        return odontologosDto;
    }
}
