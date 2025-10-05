package br.com.fiap.gh.agendamento.controller;

import br.com.fiap.gh.agendamento.doc.PerfilDocController;
import br.com.fiap.gh.agendamento.dto.PerfilDTO;
import br.com.fiap.gh.agendamento.dto.PerfilPermissaoDTO;
import br.com.fiap.gh.agendamento.service.PerfilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/perfis")
//@PreAuthorize("hasRole('ADMINISTRADOR')")
public class PerfilController implements PerfilDocController {

    private final PerfilService service;

    public PerfilController(PerfilService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<PerfilDTO>> buscarTodos() {
        return null;
    }

    @Override
    public ResponseEntity<PerfilDTO> buscarPorId(Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<PerfilDTO> cadastrar(@RequestBody String descricao){

        service.cadastrar(descricao);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @PutMapping("/{perfilId}")
    public ResponseEntity<PerfilDTO> atualizar(Long id, PerfilDTO perfilDTO) {
        return null;
    }

    @Override
    @DeleteMapping("/{perfilId}")
    public ResponseEntity<String> deletar(Long id) {
        return null;
    }

    @Override
    @GetMapping("/{perfilId}/permissoes")
    public ResponseEntity<List<PerfilPermissaoDTO>> listarPermissoes(
            @PathVariable(required = true) Long perfilId) {

        var permissoes =  service.buscarPermissoes(perfilId);
        return ResponseEntity.status(HttpStatus.OK).body(permissoes);
    }

    @Override
    @PostMapping("/{perfilId}/permissoes")
    public ResponseEntity<Void> adicionarPermissoes(
            @PathVariable(required = true) Long perfilId, Set<String> permissoes) {
        service.adicionarPermissoes(perfilId, permissoes);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @DeleteMapping("/{perfilId}/permissoes")
    public ResponseEntity<Void> removerPermissoes(
            @PathVariable(required = true)  Long perfilId, Set<String> permissoes) {
        service.removerPermissoes(perfilId, permissoes);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
