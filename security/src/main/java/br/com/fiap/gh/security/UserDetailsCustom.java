package br.com.fiap.gh.security;

import br.com.fiap.gh.jpa.entities.UsuarioEntity;
import br.com.fiap.gh.jpa.entities.UsuarioPerfilEntity;
import br.com.fiap.gh.jpa.entities.PerfilPermissaoEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDetailsCustom implements UserDetails {

    UsuarioEntity usuario;

    public UserDetailsCustom(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> authorities = new HashSet<>();

        Set<UsuarioPerfilEntity> perfis = usuario.getPerfis();

        for (UsuarioPerfilEntity perfil : perfis) {

            Set<PerfilPermissaoEntity> transacoes = perfil.getPerfil().getTransacoes();

            for(PerfilPermissaoEntity pt : transacoes) {

                var prefix = pt.getPermissao().getDescricao().toUpperCase();
                // Adiciona a role base
                authorities.add(new SimpleGrantedAuthority("ROLE_" + prefix));

                // Adiciona as permissões específicas, se forem true
                if (pt.isView())
                    authorities.add(new SimpleGrantedAuthority("VIEW_"+prefix));

                if (pt.isInsert())
                    authorities.add(new SimpleGrantedAuthority("INSERT_" + prefix));

                if (pt.isUpdate())
                    authorities.add(new SimpleGrantedAuthority("UPDATE_" + prefix));

                if (pt.isDelete())
                    authorities.add(new SimpleGrantedAuthority("DELETE_" + prefix));
            }
        }

        return authorities;
    }

    @Override
    public String getPassword() {

        return usuario.getSenha();
    }

    @Override
    public String getUsername() {

        return usuario.getLogin();
    }

    public UsuarioEntity getUsuario(){
        return  usuario;
    }
}
