package repository;

import model.Sessao;

import java.util.ArrayList;

public class SessaoRepository {
    private ArrayList<Sessao> sessoes = new ArrayList<>();

    public void adicionar(Sessao sessao) {
        sessoes.add(sessao);
    }

    public ArrayList<Sessao> listar() {
        return sessoes;
    }

    public Sessao buscarSessao(int id) {
        for (Sessao sessao : sessoes) {
            if (sessao.getId() == id) {
                return sessao;
            }
        }
        return null;
    }
}
