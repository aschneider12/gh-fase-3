package br.com.fiap.gh.agendamento.controller;

import br.com.fiap.gh.agendamento.doc.AuthenticationDocControler;
import br.com.fiap.gh.agendamento.dto.AuthRequest;
import br.com.fiap.gh.agendamento.dto.AuthResponse;
import br.com.fiap.gh.agendamento.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController implements AuthenticationDocControler {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody @Valid AuthRequest authRequest) {
        var token = authenticationService.authenticate(authRequest.username(), authRequest.password());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @Override
    @PostMapping("/validar-token")
    public ResponseEntity<String> validarToken(@RequestHeader String authorization) {
        return ResponseEntity.ok("Token recebido: " + authorization);
    }
}
