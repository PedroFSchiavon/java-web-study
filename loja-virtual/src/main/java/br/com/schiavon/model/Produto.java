package br.com.schiavon.model;

public class Produto {
    private int id;
    private int categoria;
    private String nome;
    private String descricao;

    public Produto(String nome, String descricao, int categoria){
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public Produto(int id, String nome, String descricao, int categoria){
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Produto(int id, String nome, String descricao){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public int getCategoria() {
        return categoria;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Produto: ID: %d | Nome: %s | Descricao: %s"
                , id, nome, descricao);
    }
}
