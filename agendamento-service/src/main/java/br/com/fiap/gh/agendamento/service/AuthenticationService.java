package br.com.fiap.gh.agendamento.service;

import br.com.fiap.gh.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    public AuthenticationService(AuthenticationManager authManager, JwtService jwtService) {
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    public String authenticate(String username, String password) {

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        String jwt = jwtService.generateToken((UserDetails) auth.getPrincipal());

        return jwt;
    }
}
