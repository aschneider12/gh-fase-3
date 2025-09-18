package br.com.fiap.gh.controller;

import br.com.fiap.gh.dto.ConsultaDTO;
import br.com.fiap.gh.service.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    //TODO - SERA USADO COM GRAPHQL, FEITO SO PARA TESTAR AGORA

    @PostMapping
    public ResponseEntity<String> agendarConsulta(@RequestBody ConsultaDTO consultaDTO){

        service.agendarConsulta(consultaDTO);
        //RETORNAR CONSULTAS, nao deve passar para o user admin e sim para o a1 somente
        return ResponseEntity.status(HttpStatus.OK).body("consulta agendada com sucesso!");
    }

}
