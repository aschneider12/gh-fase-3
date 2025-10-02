package br.com.fiap.gh.agendamento.controller;

import br.com.fiap.gh.agendamento.doc.PerfilDocController;
import br.com.fiap.gh.agendamento.dto.PerfilDTO;
import br.com.fiap.gh.agendamento.dto.PerfilPermissaoDTO;
import br.com.fiap.gh.agendamento.service.PerfilService;
import br.com.fiap.gh.jpa.entities.PerfilEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/perfis")
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
    public ResponseEntity<PerfilDTO> atualizar(PerfilDTO perfilDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> deletar(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<PerfilPermissaoDTO>> listarPerfis(Long usuarioId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> adicionarPerfis(Long usuarioId, Set<String> perfis) {
        return null;
    }

    @Override
    public ResponseEntity<Void> removerPerfis(Long usuarioId, Set<String> perfis) {
        return null;
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
