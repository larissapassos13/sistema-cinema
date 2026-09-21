package model;

public class Sessao {

    private int id;
    private Filme filme; // guarda o objeto Filme
    private String horario;
    private int sala;
    private int capacidade; 

    public Sessao(int id, Filme filme, String horario, int sala, int capacidade) {
        this.id = id;
        this.filme = filme;
        this.horario = horario;
        this.sala = sala;
        this.capacidade = capacidade;
    }

    public int getId() {
        return id;
    }

    public Filme getFilme() {
        return filme;
    }

    public String getHorario() {
        return horario;
    }

    public int getSala() {
        return sala;
    }

    public int getCapacidade() {
        return capacidade;
    }
    
}
