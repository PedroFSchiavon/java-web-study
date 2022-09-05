package br.com.alura.gerenciador.model;

import java.util.Date;
import java.util.Objects;

public class Empresa {
    private static Integer idIncrementavel = 0;
    private Integer id;
    private String nome;
    private Date dataCriacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCriacao(){
        return this.dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    public static Integer getIdIncrementavel(){
//        Integer idAtual = Empresa.idIncrementavel;
//        Empresa.idIncrementavel++;
        return Empresa.idIncrementavel++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
