package br.com.fiap.gh.historico.services;

import br.com.fiap.gh.historico.dto.ConsultaDTO;
import br.com.fiap.gh.jpa.entities.ConsultaEntity;
import br.com.fiap.gh.jpa.entities.UsuarioEntity;
import br.com.fiap.gh.jpa.repositories.ConsultaRepository;
import br.com.fiap.gh.security.UserDetailsCustom;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        auth.getPrincipal();

        return repository.findByPacienteId(pacienteId);
    }

    public List<ConsultaEntity> listarFuturas() {
        return repository.findByDataAfter(LocalDateTime.now());
    }

    public List<ConsultaDTO> buscarMinhasConsultas() {

       var logado = getUsuarioLogado();

        var minhasConsultas  = repository.findByPacienteId(logado.getId());

        return ConsultaDTO.fromEntity(minhasConsultas);
    }

    //TODO - da pra mover pra uma classe útil
    public UsuarioEntity getUsuarioLogado(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        var details = auth.getDetails();
        UserDetailsCustom userDetailsCustom = (UserDetailsCustom) auth.getPrincipal();
        UsuarioEntity usuario =  userDetailsCustom.getUsuario();
        return usuario;

    }
}
