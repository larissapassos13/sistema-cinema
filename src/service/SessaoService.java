package service;

import model.Filme;
import model.Sessao;
import repository.SessaoRepository;

import java.util.List;

public class SessaoService {

    private SessaoRepository repository;

    public SessaoService(SessaoRepository repository) {
        this.repository = repository;
    }

    private int proximoId = 1;

    public void cadastrarSessao(
            Filme filme,
            String horario,
            int sala,
            int capacidade) {

        Sessao sessao = new Sessao(
                proximoId,
                filme,
                horario,
                sala,
                capacidade
        );

        repository.adicionar(sessao);
        proximoId++;
    }

    public List<Sessao> listarSessoes() {
        return repository.listar();
    }
}
