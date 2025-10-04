package br.com.fiap.gh.historico.services;

import br.com.fiap.gh.historico.dto.ConsultaDTO;
import br.com.fiap.gh.historico.dto.ConsultaInput;
import br.com.fiap.gh.jpa.entities.ConsultaEntity;
import br.com.fiap.gh.jpa.entities.UsuarioEntity;
import br.com.fiap.gh.jpa.repositories.ConsultaRepository;
import br.com.fiap.gh.security.UserDetailsCustom;
import jakarta.validation.ValidationException;
import org.springframework.cglib.core.Local;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public ConsultaDTO buscarConsulta(Long idConsulta) {

        ConsultaEntity consulta = repository.findById(idConsulta)
                .orElseThrow(() -> new ValidationException("Não foi encontrada consulta com ID=" + idConsulta));

        return ConsultaDTO.fromEntity(consulta);
    }

    public List<ConsultaDTO> buscarMinhasConsultasFuturas() {
        var logado = getUsuarioLogado();
        var minhasConsultasFuturas  = repository.findByPacienteIdAndDataAfter(logado.getId(), LocalDateTime.now());
        return ConsultaDTO.fromEntity(minhasConsultasFuturas);
    }

    public List<ConsultaDTO> buscarTodasConsultasPaciente(Long idPaciente) {
        var consultasPaciente  = repository.findByPacienteId(idPaciente);
        return ConsultaDTO.fromEntity(consultasPaciente);
    }

    public List<ConsultaDTO> buscarTodasConsultasMedico(Long idMedico) {
        var consultasMedico  = repository.findByMedicoId(idMedico);
        return ConsultaDTO.fromEntity(consultasMedico);
    }

    public List<ConsultaDTO> buscarConsultasFuturasPaciente(Long idPaciente) {
        var consultasFuturasPaciente = repository.findByPacienteIdAndDataAfter(idPaciente, LocalDateTime.now());
        return ConsultaDTO.fromEntity(consultasFuturasPaciente);
    }

    public List<ConsultaDTO> buscarConsultasFuturasMedico(Long idMedico) {

        var consultasFuturasMedico = repository.findByMedicoIdAndDataAfter(idMedico, LocalDateTime.now());
        return ConsultaDTO.fromEntity(consultasFuturasMedico );
    }

    public ConsultaDTO salvarConsulta(ConsultaInput input) {

        //TODO
//        repository.save(new ConsultaEntity());
        return null;
    }

    //TODO - da pra mover pra uma classe útil
    public UsuarioEntity getUsuarioLogado(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsCustom userDetailsCustom = (UserDetailsCustom) auth.getPrincipal();
        return userDetailsCustom.getUsuario();
    }
}
