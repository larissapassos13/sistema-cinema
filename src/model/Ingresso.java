package model;

public class Ingresso {

    private int id;
    private TipoIngresso tipoIngresso;
    private Cliente cliente;
    private Sessao sessao;

    public Ingresso(int id, TipoIngresso tipoIngresso, Cliente cliente, Sessao sessao) {
        this.id = id;
        this.tipoIngresso = tipoIngresso;
        this.cliente = cliente;
        this.sessao = sessao;
    }

    public int getId() {
        return id;
    }

    public TipoIngresso getTipoIngresso() {
        return tipoIngresso;
    }

    public Cliente getCliente() {
        return cliente;
    } 

    public Sessao getSessao() {
        return sessao;
    }
    
}
