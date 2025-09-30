package br.com.fiap.gh.agendamento.controller;

import br.com.fiap.gh.jpa.entities.PermissaoEntity;
import br.com.fiap.gh.agendamento.service.PermissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController {

    private final PermissaoService service;

    public PermissaoController(PermissaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody String descricao){

        service.cadastrar(descricao);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<PermissaoEntity>> listarTodos(){

        return ResponseEntity.status(HttpStatus.OK).body(service.getAllTransacoes());
    }

}
