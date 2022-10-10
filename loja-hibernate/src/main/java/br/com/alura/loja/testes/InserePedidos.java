package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.model.*;
import br.com.alura.loja.utils.DaoUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class InserePedidos {
    public static void main(String[] args) {
        populaDB();
        EntityManager manager = new DaoUtil().getEntityManager();

        PedidoDao pedidoDao = new PedidoDao(manager);

        Cliente cliente = new ClienteDao(manager).procuraPorId(1l);
        Produto produto = new ProdutoDao(manager).procurarPorId(1l);
        Produto produto1 = new ProdutoDao(manager).procurarPorId(2l);
        Pedido pedido = new Pedido(cliente);

        pedido.adicionaItem(new ItensPedidos(5, produto));
        pedido.adicionaItem(new ItensPedidos(2, produto1));

        manager.getTransaction().begin();
        pedidoDao.Inserir(pedido);
        manager.getTransaction().commit();
        System.out.println("Valor total = " + pedidoDao.valorTotalVendido());
        manager.close();

    }

    private static void populaDB() {
        Categoria categoria = new Categoria("CELULAR");
        Categoria categoria1 = new Categoria("NOTEBOOK");
        Produto produto = new Produto("Moto e5", "Motorola ja foi bão",
                new BigDecimal("1000.01"), categoria);
        Produto produto1 = new Produto("Accer nitro 5", "notebook accer nitro top",
                new BigDecimal("3000.01"), categoria1);
        Cliente cliente = new Cliente("Pedro Schiavon", "123456789123");

        EntityManager manager = new DaoUtil().getEntityManager();
        CategoriaDao categoriaDao = new CategoriaDao(manager);
        ProdutoDao produtoDao = new ProdutoDao(manager);
        ClienteDao clienteDao = new ClienteDao(manager);

        manager.getTransaction().begin();
        categoriaDao.inserir(categoria);
        categoriaDao.inserir(categoria1);
        produtoDao.inserir(produto);
        produtoDao.inserir(produto1);
        clienteDao.Inserir(cliente);
        manager.getTransaction().commit();
        manager.close();
    }
}
