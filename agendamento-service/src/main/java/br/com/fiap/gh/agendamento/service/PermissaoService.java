package br.com.fiap.gh.agendamento.service;

import br.com.fiap.gh.agendamento.dto.PerfilDTO;
import br.com.fiap.gh.agendamento.dto.PermissaoDTO;
import br.com.fiap.gh.jpa.entities.PermissaoEntity;
import br.com.fiap.gh.jpa.repositories.PermissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoService {

    private PermissaoRepository repository;

    public PermissaoService(PermissaoRepository repository) {
        this.repository = repository;
    }

    public List<PermissaoDTO> getAllTransacoes() {

        return repository.findAll().stream().map(PermissaoDTO::create).toList();
    }

    public PermissaoDTO cadastrar(String nomeTransacao) {
        PermissaoEntity permissaoEntity = new PermissaoEntity();
        permissaoEntity.setRecurso(nomeTransacao);
        repository.save(permissaoEntity);

        return PermissaoDTO.create(permissaoEntity);
    }

    public PermissaoDTO buscarPermissaoPorId(Long permissaoId) {
        var entity = repository.findById(permissaoId)
                .orElseThrow(() -> new RuntimeException("Permissão não encontrada: " + permissaoId));

        return PermissaoDTO.create(entity);
    }

    public PermissaoDTO atualizarPermissao(Long permissaoId, String recurso) {
        var permissao  = repository.findById(permissaoId)
                .orElseThrow(() -> new RuntimeException("Permissão não encontrada: " + permissaoId));

        permissao.setRecurso(recurso);
        repository.save(permissao);

        return PermissaoDTO.create(permissao);
    }

    public void deletarPermissao(Long id) {

        var permissao  = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permissão não encontrada: " + id));

        repository.delete(permissao);
    }
}
