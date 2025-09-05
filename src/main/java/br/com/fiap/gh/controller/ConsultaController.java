package br.com.fiap.gh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/consultas")
@PreAuthorize("hasRole('CONSULTA')")
public class ConsultaController {

    //TODO - reescrever aqui tudo para consulta  e implementar os hasRole em cada metodo
    // assim é possível validar cada permissao do usuario.

    @GetMapping
    @PreAuthorize("hasAuthority('VIEW_CONSULTA')")
    public ResponseEntity<List<String>> listarTodos(){

        //RETORNAR CONSULTAS, nao deve passar para o user admin e sim para o a1 somente
        return ResponseEntity.status(HttpStatus.OK).body(Arrays.asList("Consulta 01","Consulta 02","Consulta 03"));
    }

}
