package br.com.fiap.gh.agendamento.doc;

import br.com.fiap.gh.agendamento.dto.PerfilDTO;
import br.com.fiap.gh.agendamento.dto.PermissaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

@Tag(name = "Permissões de acesso", description = "Operações relacionadas ao gerenciamento de permissões de acesso")
public interface PermissaoDocController {

    @Operation(description = "Cadastrar uma nova permissão")
    ResponseEntity<PermissaoDTO> cadastrar(String novaPermissao);

    @Operation(description = "Buscar uma permissão por ID.")
    ResponseEntity<PermissaoDTO> buscarPorId(Long id);

    @Operation(description = "Atualizar permissão existente.")
    ResponseEntity<PermissaoDTO> atualizar(Long id, String recurso);

    @Operation(description = "Deletar permissão.")
    ResponseEntity<String> deletar(Long id);

    @Operation(description = "Retorna uma lista contendo todas as permissões.")
    ResponseEntity<List<PermissaoDTO>> buscarTodos();

    //TODO - busca por nome
}
