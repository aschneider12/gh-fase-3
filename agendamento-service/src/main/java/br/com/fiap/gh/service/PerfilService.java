package br.com.fiap.gh.service;

import br.com.fiap.gh.repositories.PerfilRepository;
import br.com.fiap.gh.entities.PerfilEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    private PerfilRepository repository;

    public PerfilService(PerfilRepository repository) {
        this.repository = repository;
    }

    public List<PerfilEntity> getAllPerfis() {

        return repository.findAll();
    }

    public void cadastrar(String nomePerfil) {
        PerfilEntity perfil = new PerfilEntity();
        perfil.setDescricao(nomePerfil);
        repository.save(perfil);
    }
}
