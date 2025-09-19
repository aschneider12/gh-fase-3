package br.com.fiap.gh.controller;

import br.com.fiap.gh.dto.ConsultaDTO;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.Arrays;
import java.util.List;

@Controller
//@RequestMapping("/consultas")
//@PreAuthorize("hasRole('CONSULTA')")
public class ConsultaController {

    //TODO - reescrever aqui tudo para consulta  e implementar os hasRole em cada metodo
    // assim é possível validar cada permissao do usuario.

    @GetMapping
    @PreAuthorize("hasAuthority('VIEW_CONSULTA')")
    public ResponseEntity<List<String>> listarTodos(){

        //RETORNAR CONSULTAS, nao deve passar para o user admin e sim para o a1 somente
        return ResponseEntity.status(HttpStatus.OK).body(Arrays.asList("Consulta 01","Consulta 02","Consulta 03"));
    }

    @QueryMapping
    public List<ConsultaDTO> buscarConsultasPaciente(@Argument Long pacienteId) {

        // Lógica para buscar consultas do paciente pelo ID
        // Exemplo de retorno
        List<ConsultaDTO> consultas = Arrays.asList(
                new ConsultaDTO(1L,  "2024-07-01T10:00:00", pacienteId, "Nome paciente 1", 1l, "Médico A"),
                new ConsultaDTO(2L,  "2024-07-15T14:00:00", pacienteId,"Nome paciente 1", 2l, "Médico B")
        );

        return consultas;
    }

}
