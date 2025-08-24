package br.com.fiap.gh.controller;

import br.com.fiap.gh.dto.AuthRequest;
import br.com.fiap.gh.dto.AuthResponse;
import br.com.fiap.gh.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {

        var token = authenticationService.authenticate(authRequest.username(), authRequest.password());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
