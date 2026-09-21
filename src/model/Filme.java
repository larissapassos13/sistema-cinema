package model;

public class Filme {

    private int id;
    private String titulo;
    private int duracao;
    private String genero;
    private ClassificacaoIndicativa classificacaoIndicativa;

    public Filme(int id, String titulo, int duracao, String genero, ClassificacaoIndicativa classificacaoIndicativa) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }

    public ClassificacaoIndicativa getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }
    
}
