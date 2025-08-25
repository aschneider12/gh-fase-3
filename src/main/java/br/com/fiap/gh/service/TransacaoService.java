package br.com.fiap.gh.service;

import br.com.fiap.gh.entities.TransacaoEntity;
import br.com.fiap.gh.repositories.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    private TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public List<TransacaoEntity> getAllTransacoes() {

        return repository.findAll();
    }

    public void cadastrar(String nomeTransacao) {
        TransacaoEntity transacao = new TransacaoEntity();
        transacao.setDescricao(nomeTransacao);
        repository.save(transacao);
    }
}
