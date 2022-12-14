package br.com.alura.loja.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private LocalDate data = LocalDate.now();
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    @Column(name = "valor_total")
    private BigDecimal valorTotal = BigDecimal.ZERO;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItensPedidos> itens = new ArrayList<>();

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente clienteId) {
        this.cliente = clienteId;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void adicionaItem(ItensPedidos item){
        item.setPedido(this);
        this.itens.add(item);
        this.valorTotal = this.valorTotal.add(item.getPrecoUnitario()
                .multiply(new BigDecimal(item.getQuantidade())));
    }
}
