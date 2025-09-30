package br.com.fiap.gh.notificacao.dto;

public record NotificacaoEmailDTO(
        String subject,
        String message,
        String emailSender,
        String emailRecipient

) {
}
