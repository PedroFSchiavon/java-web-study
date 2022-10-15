package br.com.alura.loja.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Embedded
    private DadosPessoais dadosPessoais;

    public Cliente(){}

    public Cliente(String nome, String cpf){
        this.dadosPessoais = new DadosPessoais(nome, cpf);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.dadosPessoais.getNome();
    }


    public String getCpf() {
        return this.dadosPessoais.getCpf();
    }

}
