package br.com.fiap.gh.security;

import br.com.fiap.gh.entities.UsuarioEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsCustom implements UserDetails {

    UsuarioEntity usuario;

    public UserDetailsCustom(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {

        return usuario.getSenha();
    }

    @Override
    public String getUsername() {

        return usuario.getLogin();
    }
}
