package br.com.fiap.gh.notificacao.service;

import br.com.fiap.gh.notificacao.dto.NotificacaoEmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendNewEmailToPatient(NotificacaoEmailDTO messageEmailDTO) {

        System.out.println("Enviando e-mail ao paciente sobre nova consulta agendada.");
        System.out.println("Enviado por: " +messageEmailDTO.emailSender());
        System.out.println("Destinatário: " +messageEmailDTO.emailRecipient());
        System.out.println("Assunto: [" +messageEmailDTO.subject()+"]");
        System.out.println("Conteúdo - " +messageEmailDTO.message());


        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(messageEmailDTO.emailSender());
        message.setTo(messageEmailDTO.emailRecipient());
        message.setSubject(messageEmailDTO.subject());
        message.setText(messageEmailDTO.message());
        emailSender.send(message);
    }
}
