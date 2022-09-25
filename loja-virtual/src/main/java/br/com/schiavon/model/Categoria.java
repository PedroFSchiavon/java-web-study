package br.com.schiavon.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Categoria {
    private int id;
    private String nome;
    private List<Produto> produtos;

    public Categoria(int id, String nome){
        this.id = id;
        this.nome = nome;
        produtos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setProdutos(Produto produto) {
        this.produtos.add(produto);
    }

    public List<Produto> getProdutos(){
        return Collections.unmodifiableList(produtos);
    }
}
