package br.com.schiavon.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id == categoria.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
