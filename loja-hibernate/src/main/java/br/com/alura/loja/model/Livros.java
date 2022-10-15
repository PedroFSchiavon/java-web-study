package br.com.alura.loja.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "livros")
public class Livros extends Produto{
    private String autor;
    private int numeroDePaginas;

    public Livros(){}

    public Livros(String autor, int numeroDePaginas) {
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
    }

    public Livros(String nome, String descricao, BigDecimal preco, Categoria categoria, String autor, int numeroDePaginas) {
        super(nome, descricao, preco, categoria);
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }
}
