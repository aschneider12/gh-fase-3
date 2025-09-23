package br.com.fiap.gh.service;

import br.com.fiap.gh.entities.PermissaoEntity;
import br.com.fiap.gh.repositories.PermissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoService {

    private PermissaoRepository repository;

    public PermissaoService(PermissaoRepository repository) {
        this.repository = repository;
    }

    public List<PermissaoEntity> getAllTransacoes() {

        return repository.findAll();
    }

    public void cadastrar(String nomeTransacao) {
        PermissaoEntity transacao = new PermissaoEntity();
        transacao.setDescricao(nomeTransacao);
        repository.save(transacao);
    }
}
