package br.com.fiap.gh.controller;

import br.com.fiap.gh.entities.TransacaoEntity;
import br.com.fiap.gh.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody String descricao){

        service.cadastrar(descricao);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<TransacaoEntity>> listarTodos(){

        return ResponseEntity.status(HttpStatus.OK).body(service.getAllTransacoes());
    }

}
