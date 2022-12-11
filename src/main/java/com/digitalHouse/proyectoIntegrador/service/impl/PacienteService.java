package com.digitalHouse.proyectoIntegrador.service.impl;


import com.digitalHouse.proyectoIntegrador.model.Paciente;
import com.digitalHouse.proyectoIntegrador.dto.PacienteDto;
import com.digitalHouse.proyectoIntegrador.repository.IPacienteRepository;
import com.digitalHouse.proyectoIntegrador.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class PacienteService implements IPacienteService {

    //private static final Logger logger = Logger.getLogger("Capa Service: " + PacienteService.class);
    @Autowired
    private IPacienteRepository pacienteRepository;
    @Autowired
    ObjectMapper mapper;

    private void guardarPaciente(PacienteDto pacienteDTO){
        //logger.info("Inicia proceso de guardar paciente");
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
        //logger.info("Finaliza proceso de guardar paciente");
    }

    @Override
    public void crearPaciente(PacienteDto pacienteDTO) {
        //logger.info("Inicia proceso de crear paciente");
        guardarPaciente(pacienteDTO);
        //logger.info("Finaliza proceso de crear paciente");
    }

    @Override
    public PacienteDto leerPaciente(Long id) {
        //logger.info("Inicia proceso de leer paciente");
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDto pacienteDTO = null;
        if(paciente.isPresent()){
            //logger.info("Paciente encontrado");
            pacienteDTO = mapper.convertValue(paciente, PacienteDto.class);
        }
        //logger.info("Entragando resultado de leer paciente");
        return pacienteDTO;
    }

    @Override
    public void modificarPaciente(PacienteDto pacienteDTO) {
        //logger.info("Inicia proceso de modificar paciente");
        guardarPaciente(pacienteDTO);
        //logger.info("Finaliza proceso de modificar paciente");
    }

    @Override
    public void eliminarPaciente(Long id) {
        //logger.info("Inicia proceso de eliminar paciente");
        pacienteRepository.deleteById(id);
        //logger.info("Finaliza proceso de eliminar paciente");
    }

    @Override
    public Set<PacienteDto> getTodos() {
        //logger.info("Inicia proceso de mostrar todos los paciente");
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDto> pacientesDTO = new HashSet<>();

        for (Paciente paciente: pacientes){
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDto.class));
        }
        //logger.info("Entrega resultados de mostrar todos los paciente");
        return pacientesDTO;
    }
}