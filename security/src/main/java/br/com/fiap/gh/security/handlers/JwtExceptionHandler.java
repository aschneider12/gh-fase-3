package br.com.fiap.gh.security.handlers;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class JwtExceptionHandler {

    @ExceptionHandler({ MalformedJwtException.class, UnsupportedJwtException.class, SignatureException.class })
    public ResponseEntity<Object> handleExpiredJwtException(ExpiredJwtException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", Instant.now());
        body.put("status", HttpStatus.UNAUTHORIZED.value());
        body.put("error", "Token expirado");
        body.put("message", "Seu token expirou. Faça login novamente.");
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }
}
