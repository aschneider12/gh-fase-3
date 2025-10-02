package br.com.fiap.gh.agendamento.controller;

import br.com.fiap.gh.agendamento.doc.PermissaoDocController;
import br.com.fiap.gh.agendamento.doc.UsuarioDocController;
import br.com.fiap.gh.agendamento.dto.PerfilDTO;
import br.com.fiap.gh.agendamento.dto.PermissaoDTO;
import br.com.fiap.gh.jpa.entities.PermissaoEntity;
import br.com.fiap.gh.agendamento.service.PermissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController implements PermissaoDocController {

    private final PermissaoService service;

    public PermissaoController(PermissaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PerfilDTO> cadastrar(@RequestBody String recurso){

        service.cadastrar(recurso);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<PerfilDTO> buscarPorId(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<PerfilDTO> atualizar(PermissaoDTO permissaoDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> deletar(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<PermissaoDTO>> buscarTodos() {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<PermissaoEntity>> listarTodos(){

        return ResponseEntity.status(HttpStatus.OK).body(service.getAllTransacoes());
    }

}
