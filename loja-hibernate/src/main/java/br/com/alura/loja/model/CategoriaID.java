package br.com.alura.loja.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.io.Serializable;

@Embeddable
public class CategoriaID implements Serializable {
    private String nome;
    private String setor;

    public CategoriaID(String nome) {
        this.nome = nome;
        this.setor = "casa";
    }

    public CategoriaID(){}

    public String getNome() {
        return nome;
    }

    public String getSetor() {
        return setor;
    }
}
