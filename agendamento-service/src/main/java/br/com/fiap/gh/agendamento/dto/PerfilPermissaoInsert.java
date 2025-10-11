package br.com.fiap.gh.agendamento.dto;

public record PerfilPermissaoInsert(
        String recurso,
        Boolean view,
        Boolean insert,
        Boolean update,
        Boolean delete) {
}
