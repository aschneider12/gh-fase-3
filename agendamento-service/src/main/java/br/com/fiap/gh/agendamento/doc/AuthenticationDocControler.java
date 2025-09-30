package br.com.fiap.gh.agendamento.doc;

import br.com.fiap.gh.agendamento.dto.AuthRequest;
import br.com.fiap.gh.agendamento.dto.AuthResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;

@Tag(name = "Controle de autenticação de usuários",
        description = "Operações relacionadas a autorização e autenticação de acesso dos usuários")
public interface AuthenticationDocControler {

    @Operation(summary = "Autoriza o login do usuário")
    ResponseEntity<AuthResponse> authenticate(AuthRequest authRequest);

    @Operation(summary = "Validar o token enviado.")
    public ResponseEntity<String> validarToken(@RequestHeader String authorization);
}