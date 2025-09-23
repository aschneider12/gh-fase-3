package br.com.fiap.gh.notificacao.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificacaoController {

    @GetMapping("/ping")
    public String ping() {
        return "Serviço de Notificações ativo!";
    }
}
