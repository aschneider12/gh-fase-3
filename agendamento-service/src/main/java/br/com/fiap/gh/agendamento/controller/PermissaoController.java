package br.com.fiap.gh.agendamento.controller;

import br.com.fiap.gh.agendamento.doc.PermissaoDocController;
import br.com.fiap.gh.agendamento.dto.PermissaoDTO;
import br.com.fiap.gh.agendamento.service.PermissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissoes")
@PreAuthorize("hasRole('PERMISSAO')")
public class PermissaoController implements PermissaoDocController {

    private final PermissaoService service;

    public PermissaoController(PermissaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PermissaoDTO> cadastrar(@RequestBody String recurso){

        var dtoCriado = service.cadastrar(recurso);

        return ResponseEntity.status(HttpStatus.CREATED).body(dtoCriado);
    }

    @Override
    @GetMapping("/{permissaoId}")
    public ResponseEntity<PermissaoDTO> buscarPorId(@PathVariable(required = true) Long permissaoId) {

        var dto = service.buscarPermissaoPorId(permissaoId);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @Override
    @PutMapping("/{permissaoId}")
    public ResponseEntity<PermissaoDTO> atualizar(
            @PathVariable(required = true) Long permissaoId,
            @RequestBody String recurso) {

        var dto = service.atualizarPermissao(permissaoId, recurso);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @Override
    @DeleteMapping("/{permissaoId}")
    public ResponseEntity<String> deletar(@PathVariable(required = true) Long permissaoId) {

        service.deletarPermissao(permissaoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Permissão deletada com sucesso.");
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PermissaoDTO>> buscarTodos() {

        return ResponseEntity.status(HttpStatus.OK).body(service.getAllTransacoes());
    }

}
