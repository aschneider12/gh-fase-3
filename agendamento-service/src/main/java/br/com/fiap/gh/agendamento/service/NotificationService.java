package br.com.fiap.gh.agendamento.service;

import br.com.fiap.gh.agendamento.dto.ConsultaDTO;
import br.com.fiap.gh.agendamento.rabbitmq.NotificacaoEmailDTO;
import br.com.fiap.gh.agendamento.rabbitmq.NotificationPacientePublisher;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationPacientePublisher notificationPacientePublisher;

    public NotificationService(NotificationPacientePublisher notificationPacientePublisher) {
        this.notificationPacientePublisher = notificationPacientePublisher;
    }

    public void notificarPacienteSobreConsulta(ConsultaDTO consultaDTO) {

        var body = "Sua consulta com Dr "+consultaDTO.medicoNome()+" foi agendada com sucesso para o dia "+consultaDTO.dataConsulta()+"h.";

        var r = new NotificacaoEmailDTO("Nova consulta agendada", body,
                "clinica@fiap.com",consultaDTO.pacienteNome());

        notificationPacientePublisher.sendNewNotificationPaciente(r);
    }
}
