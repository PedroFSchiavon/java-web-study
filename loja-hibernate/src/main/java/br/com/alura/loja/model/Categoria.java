package br.com.alura.loja.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
    @EmbeddedId
    private CategoriaID id;

    public Categoria(){}

    public Categoria(String nome) {
        this.id = new CategoriaID(nome);
    }

    public String getNome() {
        return this.id.getNome();
    }
}
