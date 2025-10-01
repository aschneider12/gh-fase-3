package br.com.fiap.gh.agendamento.controller;

import br.com.fiap.gh.agendamento.service.PerfilService;
import br.com.fiap.gh.jpa.entities.PerfilEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfis")
public class PerfilController {

    private final PerfilService service;

    public PerfilController(PerfilService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody String descricao){

        service.cadastrar(descricao);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//    @PostMapping("/{perfilId}/permissoes")
//    public ResponseEntity<Void> vincularTransacao(
//            PathVariable Long perfilId,
//            @RequestBody PerfilRequestDTO dto
//    ){
//
//        service.cadastrar(descricao);
//
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }

    @GetMapping
    public ResponseEntity<List<PerfilEntity>> listarTodos(){

        return ResponseEntity.status(HttpStatus.OK).body(service.getAllPerfis());
    }

}
