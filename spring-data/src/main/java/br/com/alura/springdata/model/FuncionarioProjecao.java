package br.com.alura.springdata.model;

import java.math.BigDecimal;

public interface FuncionarioProjecao {
    Integer getId();
    String getNome();
    BigDecimal getSalario();
}
