package repository;

import model.Ingresso;

import java.util.ArrayList;
import java.util.List;

public class IngressoRepository {

    private ArrayList<Ingresso> ingressos = new ArrayList<>();

    public void adicionar(Ingresso ingresso){
        ingressos.add(ingresso);
    }

    public List<Ingresso> listar() {
        return ingressos;
    }

    public int contarPorSessao(int idSessao) {
        int quantidade = 0;

        for (Ingresso ingresso : ingressos) {
            if (ingresso.getSessao().getId() == idSessao) {
                // pega o ingresso ve qual sessao ele pertence e pega o id da sessao
                quantidade++;
            }
        }
        return quantidade;
    }

    public Ingresso buscarIngresso(int id){
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getId() == id){
                return ingresso;
            }
        }
        return null;
    }

    public void remover(Ingresso ingresso) {
        ingressos.remove(ingresso);
    }
}
