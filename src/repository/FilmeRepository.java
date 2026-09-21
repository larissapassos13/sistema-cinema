package repository;

import model.Filme;
import java.util.ArrayList;

public class FilmeRepository {

    private ArrayList<Filme> filmes = new ArrayList<>();

    public void adicionar(Filme filme) {
        filmes.add(filme);
    }

    public ArrayList<Filme> listar() {
        return filmes;
    }

    public Filme buscarFilme(int id) {
        for (int i = 0; i < filmes.size(); i++) {

            Filme filme = filmes.get(i);

            if (filme.getId() == id) {
                return filme;
            }
        }
        return null;
    }
}
