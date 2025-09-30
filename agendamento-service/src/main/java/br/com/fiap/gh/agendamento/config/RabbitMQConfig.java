package br.com.fiap.gh.agendamento.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "agendamento_exchange";
    public static final String NOTIFICATION_PACIENTE_QUEUE = "notification.paciente.queue";
    public static final String ROUTING_KEY_NEW_NOTIFICATION = "notification.paciente.new";

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue notificacacaoPacienteQueue(){

        return new Queue(NOTIFICATION_PACIENTE_QUEUE, true);
    }

    @Bean
    public Binding notificacaoPacienteBinding(Queue notificationQueue, DirectExchange directExchange) {

        return BindingBuilder.bind(notificationQueue).to(directExchange).with(ROUTING_KEY_NEW_NOTIFICATION);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }
}
