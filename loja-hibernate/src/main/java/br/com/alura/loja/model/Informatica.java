package br.com.alura.loja.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "informatica")
public class Informatica extends Produto{
    private String marca;
    private String modelo;

    public Informatica(){}

    public Informatica(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Informatica(String nome, String descricao, BigDecimal preco, Categoria categoria, String marca, String modelo) {
        super(nome, descricao, preco, categoria);
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
}
