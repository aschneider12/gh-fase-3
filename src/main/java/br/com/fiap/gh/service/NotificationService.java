package br.com.fiap.gh.service;

import br.com.fiap.gh.dto.ConsultaDTO;
import br.com.fiap.gh.rabbitmq.NotificationPacientePublisher;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationPacientePublisher notificationPacientePublisher;

    public NotificationService(NotificationPacientePublisher notificationPacientePublisher) {
        this.notificationPacientePublisher = notificationPacientePublisher;
    }

    public void notificarPacienteSobreConsulta(ConsultaDTO consultaDTO) {
        //TODO - Implementar lógica de notificação
        notificationPacientePublisher.sendNewNotificationPaciente("consuta agendada");
    }
}
