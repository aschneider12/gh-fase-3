package br.com.fiap.gh.agendamento.service;

import br.com.fiap.gh.agendamento.dto.ConsultaDTO;
import br.com.fiap.gh.agendamento.dto.ConsultaInsertDTO;
import br.com.fiap.gh.jpa.entities.ConsultaEntity;
import br.com.fiap.gh.jpa.entities.UsuarioEntity;
import br.com.fiap.gh.jpa.repositories.ConsultaRepository;
import br.com.fiap.gh.jpa.repositories.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

    public void agendarConsulta(ConsultaInsertDTO consultaInsertoDTO){

        UsuarioEntity paciente  = usuarioRepository.findById(consultaInsertoDTO.pacienteId())
                .orElseThrow(() -> new ValidationException("Paciente com ID="+consultaInsertoDTO.pacienteId()+" não encontrado!"));

        UsuarioEntity medico  =usuarioRepository.findById(consultaInsertoDTO.medicoId())
                .orElseThrow(() -> new ValidationException("Médico com ID="+consultaInsertoDTO.medicoId()+" não encontrado!"));


        LocalDateTime dataHoraConsulta = converterDateTime(consultaInsertoDTO.dataConsulta());

        var consulta = new ConsultaEntity(paciente, medico, dataHoraConsulta);

        consultaRepository.save(consulta);

        //validar disponibilidade, salvar no banco, etc.

        // Após agendar, enviar notificação

        var consultaDTO = new ConsultaDTO(consulta.getId(), consultaInsertoDTO.dataConsulta(), paciente.getId(), paciente.getNome(), medico.getId(), medico.getNome());
        notificationService.notificarPacienteSobreConsulta(consultaDTO);
    }

    private LocalDateTime converterDateTime(String data) {

        try {

            return LocalDateTime.parse(data, FORMATTER);

        } catch (DateTimeParseException e) {

            throw new ValidationException("O formato da data é inválido, envie como dd-MM-yyyy HH:mm");
        }
    }

}
