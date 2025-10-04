package br.com.fiap.gh.notificacao.rabbitmq;

import br.com.fiap.gh.notificacao.config.RabbitMQConfig;
import br.com.fiap.gh.notificacao.dto.NotificacaoEmailDTO;
import br.com.fiap.gh.notificacao.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationPacienteConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = RabbitMQConfig.NOTIFICATION_PACIENTE_QUEUE)
    public void notificarPaciente(NotificacaoEmailDTO messageEmailDTO) {
        /**
         * Quando uma nova mensagem é recebida pela fila o e-mail é enviado, mas pode ser qualquer
         * Outro tipo de notificação
         */
        emailService.sendNewEmailToPatient(messageEmailDTO);
    }
}
