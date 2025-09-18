package br.com.fiap.gh.rabbitmq;

import br.com.fiap.gh.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationPacienteConsumer {

    @RabbitListener(queues = RabbitMQConfig.NOTIFICATION_PACIENTE_QUEUE)
    public void notificarPaciente(String message) {
        System.out.println("Notifying patient: " + message);
    }
}
