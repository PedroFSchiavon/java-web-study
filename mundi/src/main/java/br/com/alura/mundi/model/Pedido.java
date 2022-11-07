package br.com.alura.mundi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private BigDecimal valorProduto;
    private LocalDate dataEntrega;
    private String urlProduto;
    private String descricao;
    private String urlImagem;
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;
}
