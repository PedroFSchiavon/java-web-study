package br.com.alura.loja.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
//    @Column(name = "desc")
    private String descricao;
    private BigDecimal preco;
}
