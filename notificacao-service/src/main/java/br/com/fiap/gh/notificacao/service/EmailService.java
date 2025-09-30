package br.com.fiap.gh.notificacao.service;

import br.com.fiap.gh.notificacao.dto.NotificacaoEmailDTO;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendNewEmailToPatient(NotificacaoEmailDTO messageEmailDTO) {

        System.out.println("Enviando e-mail ao paciente sobre nova consulta agendada.");
        System.out.println("Enviado por: " +messageEmailDTO.emailSender());
        System.out.println("Destinatário: " +messageEmailDTO.emailRecipient());
        System.out.println("Assunto: [" +messageEmailDTO.subject()+"]");
        System.out.println("Conteúdo - " +messageEmailDTO.message());
    }
}
