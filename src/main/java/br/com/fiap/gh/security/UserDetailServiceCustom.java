package br.com.fiap.gh.security;

import br.com.fiap.gh.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceCustom implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UserDetailServiceCustom(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuario = usuarioRepository.findByLogin(username)
                    .orElseThrow(() -> new UsernameNotFoundException(username+ " not found!"));
        return new UserDetailCustom(usuario);
    }
}
