package br.com.fiap.gh.historico.services;

import br.com.fiap.gh.jpa.entities.ConsultaEntity;
import br.com.fiap.gh.jpa.repositories.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public List<ConsultaEntity> listarTodas() {

        return repository.findAll();
    }

    public List<ConsultaEntity> listarPorPaciente(Long pacienteId) {
        return repository.findByPacienteId(pacienteId);
    }

    public List<ConsultaEntity> listarFuturas() {
        return repository.findByDataAfter(LocalDateTime.now());
    }
}
