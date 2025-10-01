package br.com.fiap.gh.agendamento.service;

import br.com.fiap.gh.jpa.repositories.PerfilRepository;
import br.com.fiap.gh.jpa.entities.PerfilEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    public PerfilEntity buscarPerfilPorNome(String descricao) {
        PerfilEntity perfil = repository.findByDescricao(descricao)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado: " + descricao));

        return perfil;
    }
}
