package br.com.fiap.gh.agendamento.doc;

import br.com.fiap.gh.agendamento.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Set;

@Tag(name = "Controle de usuários",
        description = "Operações relacionadas ao CRUD dos usuários e seus perfis de acesso")
@PreAuthorize("hasAnyRole('USUARIO','USUARIO_PERFIL')")
public interface UsuarioDocController {

    @Operation(description = "Buscar um usuário por ID.")
    @PreAuthorize("hasAuthority('VIEW_USUARIO')")
    ResponseEntity<UsuarioResponseDTO> buscarPorId(Long id);

    @Operation(description = "Retorna uma lista contendo todos os usuários.")
    @PreAuthorize("hasAuthority('VIEW_USUARIO')")
    ResponseEntity<List<UsuarioResponseDTO>> buscarTodos();

    @Operation(description = "Cadastrar um novo usuário")
    @PreAuthorize("hasAuthority('INSERT_USUARIO')")
    ResponseEntity<UsuarioResponseDTO> cadastrar(UsuarioInsertDTO usuarioDTO);

    @Operation(description = "Atualizar usuário existente.")
    @PreAuthorize("hasAuthority('UPDATE_USUARIO')")
    ResponseEntity<UsuarioResponseDTO> atualizar(UsuarioUpdateDTO usuarioDTO, Long id);

    @Operation(description = "Deletar usuário.")
    @PreAuthorize("hasAuthority('DELETE_USUARIO')")
    ResponseEntity<String> deletar(Long id);

    @Operation(summary = "Altera a senha do usuário.")
    ResponseEntity<Void> mudarSenha(MudarSenhaDTO mudarSenhaDTO, Long id);

    @Operation(summary = "Listar perfis", description = "Listar todos os perfis vinculados ao usuário cadastrado")
    @PreAuthorize("hasAuthority('VIEW_USUARIO_PERFIL')")
    public ResponseEntity<List<PerfilDTO>> listarPerfis(Long usuarioId);

    @Operation(summary = "Cadastrar novo perfil", description = "Realiza a associação dos perfis ao usuário cadastrado")
    @PreAuthorize("hasAuthority('INSERT_USUARIO_PERFIL')")
    public ResponseEntity<Void> adicionarPerfis(Long usuarioId, Set<String> perfis);

    @Operation(summary = "Remover perfil", description = "Remove os perfis associados ao cadastro do usuário")
    @PreAuthorize("hasAuthority('DELETE_USUARIO_PERFIL')")
    public ResponseEntity<Void> removerPerfis(Long usuarioId, Set<String> perfis);
}