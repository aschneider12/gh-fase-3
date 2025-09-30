package br.com.fiap.gh.agendamento.controller;

import br.com.fiap.gh.jpa.entities.UsuarioEntity;
import br.com.fiap.gh.agendamento.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController  {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> buscarTodos() {

        var response = service.getAllUsuarios();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
