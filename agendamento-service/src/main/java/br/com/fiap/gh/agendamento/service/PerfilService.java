package br.com.fiap.gh.agendamento.service;

import br.com.fiap.gh.agendamento.dto.PerfilDTO;
import br.com.fiap.gh.agendamento.dto.PerfilPermissaoDTO;
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

    public List<PerfilDTO> getAllPerfis() {
        var perfis = repository.findAll();

        List<PerfilDTO> dtos = perfis.stream()
                .map(PerfilDTO::create)
                .toList();

        return dtos;
    }

    public PerfilDTO cadastrar(String nomePerfil) {
        repository.findByDescricao(nomePerfil)
                .ifPresent(perfil -> {
                    throw new RuntimeException("Perfil já cadastrado: " + nomePerfil);
                });
        PerfilEntity perfil = new PerfilEntity();
        perfil.setDescricao(nomePerfil);
        repository.save(perfil);

        return PerfilDTO.create(perfil);
    }

    public PerfilEntity buscarPerfilPorNome(String descricao) {
        PerfilEntity perfil = repository.findByDescricao(descricao)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado: " + descricao));

        return perfil;
    }

    public List<PerfilPermissaoDTO> buscarPermissoes(Long perfilId) {

        return repository.findById(perfilId)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado: " + perfilId))
                .getPermissoes().stream()
                .map(PerfilPermissaoDTO::create)
                .toList();
    }

    public void adicionarPermissoes(Long perfilId, Set<String> permissoes) {
    }

    public void removerPermissoes(Long perfilId, Set<String> permissoes) {
    }

    public PerfilDTO buscarPerfilById(Long id) {
        return repository.findById(id)
                .map(PerfilDTO::create)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado: " + id));
    }

    public PerfilDTO atualizarPerfil(Long perfilId, String descricao) {
       var perfil  = repository.findById(perfilId)
               .orElseThrow(() -> new RuntimeException("Perfil não encontrado: " + perfilId));

       perfil.setDescricao(descricao);
       repository.save(perfil);

         return PerfilDTO.create(perfil);
    }

    public void deletarPerfil(Long id) {

        var perfil  = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado: " + id));

        repository.delete(perfil);
    }
}
