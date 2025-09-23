package br.com.fiap.gh.historico.services;

import br.com.fiap.gh.historico.entities.Consulta;
import br.com.fiap.gh.historico.repositories.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public List<Consulta> listarTodas() {
        return repository.findAll();
    }

    public List<Consulta> listarPorPaciente(Long pacienteId) {
        return repository.findByPacienteId(pacienteId);
    }

    public List<Consulta> listarFuturas() {
        return repository.findByDataAfter(LocalDateTime.now());
    }
}
