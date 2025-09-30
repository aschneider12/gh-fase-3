package br.com.fiap.gh.agendamento.controller;

import br.com.fiap.gh.agendamento.dto.ConsultaInsertDTO;
import br.com.fiap.gh.agendamento.service.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamento")
@PreAuthorize("hasRole('CONSULTA')")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('INSERT_CONSULTA')")
    public ResponseEntity<String> agendarConsulta(@RequestBody ConsultaInsertDTO consultaDTO){

        service.agendarConsulta(consultaDTO);

        //RETORNAR CONSULTAS, nao deve passar para o user admin e sim para o a1 somente
        return ResponseEntity.status(HttpStatus.OK).body("Consulta agendada com sucesso!");
    }

}
