package br.com.fiap.gh.agendamento.dto;

import java.util.Set;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String login,
        String email,
        Set<String> perfis
) {
}
