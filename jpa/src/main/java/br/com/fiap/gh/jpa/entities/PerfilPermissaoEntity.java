package br.com.fiap.gh.jpa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity(name = "perfil_permissao")
public class PerfilPermissaoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    @JsonBackReference
    private PerfilEntity perfil;

    @ManyToOne
    @JoinColumn(name = "permissao_id")
    private PermissaoEntity permissao;

    private boolean view;
    private boolean insert;
    private boolean update;
    private boolean delete;

    public PerfilPermissaoEntity() {

    }

    public PerfilPermissaoEntity(PerfilEntity perfil, PermissaoEntity permissao,
                                 boolean view, boolean insert, boolean update, boolean delete) {
        this.perfil = perfil;
        this.permissao = permissao;
        this.view = view;
        this.insert = insert;
        this.update = update;
        this.delete = delete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PerfilEntity getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

    public boolean isView() {
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }

    public boolean isInsert() {
        return insert;
    }

    public void setInsert(boolean insert) {
        this.insert = insert;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public PermissaoEntity getPermissao() {
        return permissao;
    }

    public void setPermissao(PermissaoEntity permissao) {
        this.permissao = permissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PerfilPermissaoEntity that = (PerfilPermissaoEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
