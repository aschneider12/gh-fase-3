package br.com.fiap.gh.agendamento.controller;

import br.com.fiap.gh.agendamento.doc.UsuarioDocController;
import br.com.fiap.gh.agendamento.dto.*;
import br.com.fiap.gh.jpa.entities.UsuarioEntity;
import br.com.fiap.gh.agendamento.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController implements UsuarioDocController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrar(
            @RequestBody UsuarioInsertDTO usuarioDTO) {

        var response = service.cadastrarUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @PutMapping("/{usuarioId}")
    public ResponseEntity<UsuarioResponseDTO> atualizar(
            @RequestBody UsuarioUpdateDTO usuarioDTO,
            @PathVariable(required = true)Long usuarioId) {
        return null;
    }

    @Override
    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<String> deletar(@PathVariable(required = true) Long usuarioId) {

        service.deletar(usuarioId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuário deletado com sucesso");
    }

    @Override
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> buscarTodos() {

        var response = service.getAllUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(
            @PathVariable(required = true) Long usuarioId) {
        var response = service.getUsuarioById(usuarioId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    @PatchMapping("/{usuarioId}/mudar-senha")
    public ResponseEntity<Void> mudarSenha(
                @RequestBody(required = true) MudarSenhaDTO mudarSenhaDTO,
                @PathVariable(required = true)  Long usuarioId) {
         service.mudarSenha(mudarSenhaDTO, usuarioId);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    @GetMapping("/{usuarioId}/perfis")
    public ResponseEntity<List<PerfilPermissaoDTO>> listarPerfis(@PathVariable(required = true) Long usuarioId) {
        return null;
    }

    @Override
    @PostMapping("/{usuarioId}/perfis")
    public ResponseEntity<Void> adicionarPerfis(
            @PathVariable(required = true) Long usuarioId,
            @RequestBody Set<String> perfis) {
        return null;
    }

    @Override
    @DeleteMapping("/{usuarioId}/perfis")
    public ResponseEntity<Void> removerPerfis(
            @PathVariable(required = true) Long usuarioId,
            @RequestBody Set<String> perfis) {
        return null;
    }

}
