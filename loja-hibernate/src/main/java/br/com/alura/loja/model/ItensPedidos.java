package br.com.alura.loja.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedidos")
public class ItensPedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private BigDecimal precoUnitario;
    private int quantidade;
    @ManyToOne
    private Produto produtoId;
    @ManyToOne
    private Pedido pedidoIda;

    public ItensPedidos(int quantidade, Produto produtoId, Pedido pedidoIda) {
        this.quantidade = quantidade;
        this.produtoId = produtoId;
        this.pedidoIda = pedidoIda;
    }

    public ItensPedidos(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }

    public Pedido getPedidoIda() {
        return pedidoIda;
    }

    public void setPedidoIda(Pedido pedidoIda) {
        this.pedidoIda = pedidoIda;
    }
}
