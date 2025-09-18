package br.com.fiap.gh.service;

import br.com.fiap.gh.repositories.UsuarioRepository;
import br.com.fiap.gh.entities.UsuarioEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioEntity> getAllUsuarios() {

        return repository.findAll();
    }
}
