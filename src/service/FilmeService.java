package service;

import java.util.List;

import model.ClassificacaoIndicativa;
import model.Filme;
import repository.FilmeRepository;

public class FilmeService {

    private FilmeRepository repository;

    public FilmeService() {
        repository = new FilmeRepository();
    }

    private int proximoId = 1;

    public void cadastrarFilme( // gera o id
            String titulo,
            int duracao,
            String genero,
            ClassificacaoIndicativa classificacaoIndicativa) {

        Filme filme = new Filme(
                proximoId,
                titulo,
                duracao,
                genero,
                classificacaoIndicativa
        );
        repository.adicionar(filme);

        proximoId++; // incrementa o prox id
    }

    public List<Filme> listarFilmes() {
        return repository.listar();
    }

    public Filme buscarFilme(int id) {
        return repository.buscarFilme(id);
    }
}
