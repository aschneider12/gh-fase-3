package br.com.fiap.gh.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthRequest(
        @NotBlank
        String username,

        @NotBlank
        String password) {
}
