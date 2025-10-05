package br.com.fiap.gh.agendamento.dto;

import br.com.fiap.gh.jpa.entities.UsuarioEntity;

import java.util.Set;
import java.util.stream.Collectors;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String login,
        String email,
        Set<String> perfis
) {

    public static UsuarioResponseDTO create(UsuarioEntity usuarioEntidade) {
        return new UsuarioResponseDTO(usuarioEntidade.getId(),
                usuarioEntidade.getNome(),
                usuarioEntidade.getLogin(),
                usuarioEntidade.getEmail(),
                usuarioEntidade.getPerfis().stream().map(
                        p -> p.getPerfil().getDescricao()).collect(Collectors.toSet()));
    }
}
