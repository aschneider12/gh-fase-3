package br.com.fiap.gh.controller;

import br.com.fiap.gh.doc.AuthenticationDocControler;
import br.com.fiap.gh.dto.AuthRequest;
import br.com.fiap.gh.dto.AuthResponse;
import br.com.fiap.gh.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<String> validarToken(String authorization) {

        //TODO - copiar do tech21
        return null;
    }
}
