package br.com.fiap.gh.agendamento.dto;

import br.com.fiap.gh.jpa.entities.PerfilEntity;

public record PerfilDTO(Long id, String descricao) {

    public static PerfilDTO create(PerfilEntity entity) {
        return new PerfilDTO(entity.getId(), entity.getDescricao());
    }
}
