package br.com.alura.loja.dao;

import br.com.alura.loja.model.Cliente;
import br.com.alura.loja.model.Pedido;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class PedidoDao {
    private EntityManager manager;

    public PedidoDao(EntityManager manager){
        this.manager = manager;
    }

    public void Inserir(Pedido pedido){
        this.manager.persist(pedido);
    }

    public Pedido procuraPorId(long id){
        return this.manager.find(Pedido.class, id);
    }

    public BigDecimal valorTotalVendido(){
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return this.manager.createQuery(jpql, BigDecimal.class).getSingleResult();
    }
}
