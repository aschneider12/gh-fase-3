package br.com.fiap.gh.rabbitmq;

import br.com.fiap.gh.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class NotificationPacientePublisher {

    private final RabbitTemplate rabbitTemplate;

    public NotificationPacientePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendNewNotificationPaciente(String message) {

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY_NEW_NOTIFICATION, message);
    }
}
