package br.com.fiap.gh.service;

import br.com.fiap.gh.entity.Usuario;
import br.com.fiap.gh.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optionalUser = usuarioRepository.findByUsuario(username);

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }

       Usuario usuario = optionalUser.get();

        return org.springframework.security.core.userdetails.User.builder()
                .username(usuario.getUsuario())
                .password(usuario.getSenha())
                .roles(usuario.getPerfil())
                .build();
    }
}
