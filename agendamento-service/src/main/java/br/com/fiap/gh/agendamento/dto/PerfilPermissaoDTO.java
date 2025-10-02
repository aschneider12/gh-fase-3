package br.com.fiap.gh.agendamento.dto;

public record PerfilPermissaoDTO(
        String perfil,
        String recurso,
        Boolean view,
        Boolean insert,
        Boolean update,
        Boolean delete) {
}
