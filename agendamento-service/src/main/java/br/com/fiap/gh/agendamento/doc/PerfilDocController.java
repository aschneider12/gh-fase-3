package br.com.fiap.gh.agendamento.doc;
import br.com.fiap.gh.agendamento.dto.*;
import br.com.fiap.gh.jpa.entities.PerfilEntity;
import br.com.fiap.gh.jpa.entities.PermissaoEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

@Tag(name = "Perfis de acesso", description = "Operações relacionadas ao gerenciamento dos perfis de acesso e suas permissões")
public interface PerfilDocController {

    @Operation(description = "Retorna uma lista contendo todos os perfis.")
    ResponseEntity<List<PerfilDTO>> buscarTodos();

    @Operation(description = "Buscar um perfil por ID.")
    ResponseEntity<PerfilDTO> buscarPorId(Long id);

    @Operation(description = "Cadastrar um novo perfil")
    ResponseEntity<PerfilDTO> cadastrar(String novoPerfil);

    @Operation(description = "Atualizar perfil existente.")
    ResponseEntity<PerfilDTO> atualizar(PerfilDTO perfilDTO);

    @Operation(description = "Deletar perfil.")
    ResponseEntity<String> deletar(Long id);

    @Operation(summary = "Listar permissões", description = "Listar todos os perfis vinculados ao usuário cadastrado")
    public ResponseEntity<List<PerfilPermissaoDTO>> listarPerfis(Long usuarioId);

    @Operation(summary = "Associar permissão ao perfil", description = "Realiza a associação dos perfis ao usuário cadastrado")
    public ResponseEntity<Void> adicionarPerfis(Long usuarioId, Set<String> perfis);

    @Operation(summary = "Remover permissão do perfil", description = "Remove os perfis associados ao cadastro do usuário")
    public ResponseEntity<Void> removerPerfis(Long usuarioId, Set<String> perfis);

}
