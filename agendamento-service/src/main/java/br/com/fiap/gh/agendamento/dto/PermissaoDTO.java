package br.com.fiap.gh.agendamento.dto;

import br.com.fiap.gh.jpa.entities.PermissaoEntity;

public record PermissaoDTO(Long id, String recurso) {

    public static PermissaoDTO create(PermissaoEntity entity) {
        return new PermissaoDTO(entity.getId(), entity.getRecurso());
    }
}
