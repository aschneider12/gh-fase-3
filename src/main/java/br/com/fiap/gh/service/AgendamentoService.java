package br.com.fiap.gh.service;

import br.com.fiap.gh.dto.ConsultaDTO;
import br.com.fiap.gh.rabbitmq.NotificationPacientePublisher;
import br.com.fiap.gh.repositories.ConsultaRepository;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    private final ConsultaRepository consultaRepository;

    private final NotificationService  notificationService;

    public AgendamentoService(ConsultaRepository consultaRepository, NotificationService notificationService) {
        this.consultaRepository = consultaRepository;
        this.notificationService = notificationService;
    }

    public void agendarConsulta(ConsultaDTO consultaDTO){

        //validar disponibilidade, salvar no banco, etc.
        //TODO - se foi alterada enviar notificacao ao medico tambem
        //TODO - se foi criada enviar notificacao somente ao paciente

        // Após agendar, enviar notificação

        notificationService.notificarPacienteSobreConsulta(consultaDTO);
    }
}
