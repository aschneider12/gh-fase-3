package br.com.fiap.gh.agendamento.rabbitmq;

import br.com.fiap.gh.agendamento.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificationPacientePublisher {

    private final RabbitTemplate rabbitTemplate;

    public NotificationPacientePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendNewNotificationPaciente(NotificacaoEmailDTO message) {

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY_NEW_NOTIFICATION, message);
    }
}
