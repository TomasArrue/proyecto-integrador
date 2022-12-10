package com.digitalHouse.proyectoIntegrador.service.impl;

import com.digitalHouse.proyectoIntegrador.dto.DomicilioDto;
import com.digitalHouse.proyectoIntegrador.model.Domicilio;
import com.digitalHouse.proyectoIntegrador.repository.IDomicilioRepository;
import com.digitalHouse.proyectoIntegrador.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService {

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarDomicilio(DomicilioDto domicilioDTO){
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
    }

    @Override
    public void crearDomicilio(DomicilioDto domicilioDto) {
        guardarDomicilio(domicilioDto);
    }

    @Override
    public DomicilioDto leerDomicilio(Long id) {
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDto domicilioDTO = null;
        if(domicilio.isPresent()){
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDto.class);
        }
        return domicilioDTO;
    }

    @Override
    public void modificarDomicilio(DomicilioDto domicilioDto) { guardarDomicilio(domicilioDto);}

    @Override
    public void eliminarDomicilio(Long id) { domicilioRepository.deleteById(id); }

    @Override
    public Set<DomicilioDto> getTodos() {
       List<Domicilio> domicilios = domicilioRepository.findAll();
       Set<DomicilioDto> domiciliosDTO = new HashSet<>();

       for (Domicilio domicilio: domicilios){
           domiciliosDTO.add(mapper.convertValue(domicilio, DomicilioDto.class));
       }

       return domiciliosDTO;
    }
}
