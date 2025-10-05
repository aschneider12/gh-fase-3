package br.com.fiap.gh.agendamento.service;

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

    public void cadastrar(String nomeTransacao) {
        PermissaoEntity transacao = new PermissaoEntity();
        transacao.setRecurso(nomeTransacao);
        repository.save(transacao);
    }
}
