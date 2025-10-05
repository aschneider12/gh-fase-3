package br.com.fiap.gh.agendamento.dto;

import br.com.fiap.gh.jpa.entities.PerfilPermissaoEntity;

public record PerfilPermissaoDTO(
        String perfil,
        String recurso,
        Boolean view,
        Boolean insert,
        Boolean update,
        Boolean delete) {

    public static PerfilPermissaoDTO create(PerfilPermissaoEntity entity) {
        return new PerfilPermissaoDTO(
                entity.getPerfil().getDescricao(),
                entity.getPermissao().getRecurso(),
                entity.isView() ,
                entity.isInsert(),
                entity.isUpdate(),
                entity.isDelete()
        );
    }
}
