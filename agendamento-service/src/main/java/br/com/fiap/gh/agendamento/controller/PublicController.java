package br.com.fiap.gh.agendamento.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping
    public String publicGet(){

        return "<h4> PÁGINA PÚBLICA - OK</h4>";
    }
}
