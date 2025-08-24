package br.com.fiap.gh.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

//    private final JwtEncoder jwtEncoder;
//
//    public JwtService(JwtEncoder jwtEncoder) {
//        this.jwtEncoder = jwtEncoder;
//    }

    public String generateToken(Authentication authentication) {

        return "token";
    }
}
