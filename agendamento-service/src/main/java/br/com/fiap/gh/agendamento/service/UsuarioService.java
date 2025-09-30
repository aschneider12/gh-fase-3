package br.com.fiap.gh.agendamento.service;

import br.com.fiap.gh.jpa.repositories.UsuarioRepository;
import br.com.fiap.gh.jpa.entities.UsuarioEntity;
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
