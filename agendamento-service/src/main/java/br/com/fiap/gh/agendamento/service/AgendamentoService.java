package br.com.fiap.gh.agendamento.service;

import br.com.fiap.gh.agendamento.dto.ConsultaDTO;
import br.com.fiap.gh.agendamento.dto.ConsultaInsert;
import br.com.fiap.gh.agendamento.dto.ConsultaUpdate;
import br.com.fiap.gh.jpa.entities.ConsultaEntity;
import br.com.fiap.gh.jpa.entities.UsuarioEntity;
import br.com.fiap.gh.jpa.repositories.ConsultaRepository;
import br.com.fiap.gh.jpa.repositories.UsuarioRepository;
import br.com.fiap.gh.security.EnumPerfilAutorizado;
import br.com.fiap.gh.security.UserDetailsCustom;
import jakarta.validation.ValidationException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    private final ConsultaRepository consultaRepository;
    private final UsuarioRepository usuarioRepository;

    private final NotificationService  notificationService;

    public AgendamentoService(ConsultaRepository consultaRepository, UsuarioRepository usuarioRepository, NotificationService notificationService) {
        this.consultaRepository = consultaRepository;
        this.usuarioRepository = usuarioRepository;
        this.notificationService = notificationService;
    }

    public void agendarConsulta(ConsultaInsert consultaInsert){

        validarAutorizacaoMedico(consultaInsert.medicoId());

        UsuarioEntity paciente  = usuarioRepository.findById(consultaInsert.pacienteId())
                .orElseThrow(() -> new ValidationException("Paciente com ID="+consultaInsert.pacienteId()+" não encontrado!"));

        UsuarioEntity medico  =usuarioRepository.findById(consultaInsert.medicoId())
                .orElseThrow(() -> new ValidationException("Médico com ID="+consultaInsert.medicoId()+" não encontrado!"));


        LocalDateTime dataHoraConsulta = converterDateTime(consultaInsert.dataConsulta());

        var consulta = new ConsultaEntity(paciente, medico, dataHoraConsulta);

        consultaRepository.save(consulta);

        //validar disponibilidade, salvar no banco, etc.

        // Após agendar, enviar notificação

        var consultaDTO = new ConsultaDTO(consulta.getId(), consultaInsert.dataConsulta(), paciente.getId(), paciente.getNome(), paciente.getEmail(), medico.getId(), medico.getNome());
        notificationService.notificarPacienteSobreConsulta(consultaDTO);
    }

    public void atualizarConsulta(ConsultaUpdate consultaUpdate) {

        validarAutorizacaoMedico(consultaUpdate.medicoId());

        var consulta = consultaRepository.findById(consultaUpdate.consultaId())
                .orElseThrow(() -> new ValidationException("Consulta com ID=" + consultaUpdate.medicoId() + " não encontrada!"));

        if (consultaUpdate.medicoId() != consulta.getMedico().getId()){
            UsuarioEntity medico = usuarioRepository.findById(consultaUpdate.medicoId())
                    .orElseThrow(() -> new ValidationException("Médico com ID=" + consultaUpdate.medicoId() + " não encontrado!"));
            consulta.setMedico(medico);
        }

        if(consultaUpdate.pacienteId() != consulta.getPaciente().getId()) {

            UsuarioEntity paciente = usuarioRepository.findById(consultaUpdate.pacienteId())
                    .orElseThrow(() -> new ValidationException("Paciente com ID=" + consultaUpdate.pacienteId() + " não encontrado!"));
            consulta.setPaciente(paciente);
        }

        LocalDateTime dataHoraConsulta = converterDateTime(consultaUpdate.dataConsulta());
        consulta.setData(dataHoraConsulta);
        consultaRepository.save(consulta);
        // Após agendar, enviar notificação

        var consultaDTO = new ConsultaDTO(consulta.getId(),
                consultaUpdate.dataConsulta(), consulta.getId(),
                consulta.getPaciente().getNome(), consulta.getPaciente().getEmail(),
                consulta.getMedico().getId(), consulta.getMedico().getNome());

        notificationService.notificarPacienteSobreConsulta(consultaDTO);
    }

    private void validarAutorizacaoMedico(Long medicoId) {
        var usuario = getUsuarioLogado();
        if(possuiPerfil("MEDICO") && !usuario.getId().equals(medicoId)) {

            throw new AccessDeniedException("Médico só pode alterar suas próprias consultas!");
        }
    }

    private LocalDateTime converterDateTime(String data) {

        try {

            return LocalDateTime.parse(data, FORMATTER);

        } catch (DateTimeParseException e) {

            throw new ValidationException("O formato da data é inválido, envie como dd-MM-yyyy HH:mm");
        }
    }

    public UsuarioEntity getUsuarioLogado(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsCustom userDetailsCustom = (UserDetailsCustom) auth.getPrincipal();

        return userDetailsCustom.getUsuario();
    }

    public boolean possuiPerfil(String perfil){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || perfil == null) return false;

        return auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(authority -> authority.equalsIgnoreCase("ROLE_" + perfil));
    }

}
