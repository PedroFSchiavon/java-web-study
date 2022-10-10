package br.com.alura.loja.dao;

import br.com.alura.loja.model.Cliente;
import br.com.alura.loja.model.Pedido;
import br.com.alura.loja.vo.RelatorioVendasVO;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

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

    public List<RelatorioVendasVO> relatorioDeVendas(){
        String jpql = "SELECT new br.com.alura.loja.vo.RelatorioVendasVO " +
                "(produto.nome, " +
                "SUM(item.quantidade), " +
                "MAX(pedido.data)) " +
                "FROM Pedido pedido " +
                "JOIN pedido.itens item " +
                "JOIN item.produto produto " +
                "GROUP BY produto.nome " +
                "ORDER BY item.quantidade DESC";

        return this.manager.createQuery(jpql, RelatorioVendasVO.class).getResultList();
    }
}
