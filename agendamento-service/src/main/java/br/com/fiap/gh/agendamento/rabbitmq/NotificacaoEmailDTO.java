package br.com.fiap.gh.agendamento.rabbitmq;

public record NotificacaoEmailDTO(
        String subject,
        String message,
        String emailSender,
        String emailRecipient
) {
}