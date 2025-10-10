package br.com.fiap.gh.agendamento.doc;
import br.com.fiap.gh.agendamento.dto.*;
import br.com.fiap.gh.jpa.entities.PerfilEntity;
import br.com.fiap.gh.jpa.entities.PermissaoEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    ResponseEntity<PerfilDTO> atualizar(Long id, String novaDescricao);

    @Operation(description = "Deletar perfil.")
    ResponseEntity<String> deletar(Long id);

    @Operation(summary = "Listar permissões", description = "Listar todas as permissões associadas ao perfil")
    public ResponseEntity<List<PerfilPermissaoDTO>> listarPermissoes(Long perfilId);

    @Operation(summary = "Associar permissão ao perfil", description = "Realiza a associação dos das permissões ao perfil.")
    public ResponseEntity<Void> adicionarPermissoes(Long usuarioId, Set<String> perfis);

    @Operation(summary = "Remover permissão do perfil", description = "Remove as permissões associadas ao perfil.")
    public ResponseEntity<Void> removerPermissoes(Long perfilId, Set<String> permissoes);

}
