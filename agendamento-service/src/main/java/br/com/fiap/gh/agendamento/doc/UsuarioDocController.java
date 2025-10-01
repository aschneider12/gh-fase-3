package br.com.fiap.gh.agendamento.doc;

import br.com.fiap.gh.agendamento.dto.MudarSenhaDTO;
import br.com.fiap.gh.agendamento.dto.UsuarioInsertDTO;
import br.com.fiap.gh.agendamento.dto.UsuarioResponseDTO;
import br.com.fiap.gh.agendamento.dto.UsuarioUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

@Tag(name = "Controle de usuários",
        description = "Operações relacionadas ao CRUD dos usuários e seus perfis de acesso")
public interface UsuarioDocController {

    @Operation(description = "Cadastrar um novo usuário")
    ResponseEntity<UsuarioResponseDTO> cadastrar(UsuarioInsertDTO usuarioDTO);

    @Operation(description = "Atualizar usuário existente.")
    ResponseEntity<UsuarioResponseDTO> atualizar(UsuarioUpdateDTO usuarioDTO, Long id);

    @Operation(description = "Deletar usuário.")
    ResponseEntity<String> deletar(Long id);

    @Operation(description = "Retorna uma lista contendo todos os usuários.")
    ResponseEntity<List<UsuarioResponseDTO>> buscarTodos();

    @Operation(description = "Buscar um usuário por ID.")
    ResponseEntity<UsuarioResponseDTO> buscarPorId(Long id);

    @Operation(summary = "Altera a senha do usuário.")
    ResponseEntity<Void> mudarSenha(MudarSenhaDTO mudarSenhaDTO, Long id);

    @Operation(summary = "Listar perfis", description = "Listar todos os perfis vinculados ao usuário cadastrado")
    public ResponseEntity<List<String>> listarPerfis(Long usuarioId);

    @Operation(summary = "Cadastrar novo perfil", description = "Realiza a associação dos perfis ao usuário cadastrado")
    public ResponseEntity<Void> adicionarPerfis(Long usuarioId, Set<String> perfis);

    @Operation(summary = "Remover perfil", description = "Remove os perfis associados ao cadastro do usuário")
    public ResponseEntity<Void> removerPerfis(Long usuarioId, Set<String> perfis);
}