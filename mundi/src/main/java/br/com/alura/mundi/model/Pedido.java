package br.com.alura.mundi.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class Pedido {
    private String nomeProduto;
    private BigDecimal valorProduto;
    private LocalDate dataEntrega;
    private String urlProduto;
    private String descricao;
    private String urlImagem;
}
