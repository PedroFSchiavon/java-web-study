package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.model.*;
import br.com.alura.loja.utils.DaoUtil;
import br.com.alura.loja.vo.RelatorioVendasVO;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class InserePedidos {
    public static void main(String[] args) {
        populaDB();
        EntityManager manager = new DaoUtil().getEntityManager();

        PedidoDao pedidoDao = new PedidoDao(manager);

        Cliente cliente = new ClienteDao(manager).procuraPorId(1l);
        Cliente cliente1 = new ClienteDao(manager).procuraPorId(2l);
        Produto produto = new ProdutoDao(manager).procurarPorId(1l);
        Produto produto1 = new ProdutoDao(manager).procurarPorId(2l);
        Produto produto2 = new ProdutoDao(manager).procurarPorId(3l);
        Produto produto3 = new ProdutoDao(manager).procurarPorId(4l);
        Pedido pedido = new Pedido(cliente);
        Pedido pedido1 = new Pedido(cliente1);

        pedido.adicionaItem(new ItensPedidos(5, produto));
        pedido.adicionaItem(new ItensPedidos(2, produto1));
        pedido1.adicionaItem(new ItensPedidos(10, produto2));
        pedido1.adicionaItem(new ItensPedidos(20, produto3));

        manager.getTransaction().begin();
        pedidoDao.Inserir(pedido);
        pedidoDao.Inserir(pedido1);
        manager.getTransaction().commit();
        System.out.println("Valor total = " + pedidoDao.valorTotalVendido());
        List<RelatorioVendasVO> relatorios = pedidoDao.relatorioDeVendas();
        manager.close();

       relatorios.forEach(System.out::println);

    }

    private static void populaDB() {
        Categoria categoria = new Categoria("CELULAR");
        Categoria categoria1 = new Categoria("NOTEBOOK");
        Categoria categoria2 = new Categoria("VIDEOGAME");

        Produto produto = new Produto("Moto e5", "Motorola ja foi bão",
                new BigDecimal("1000.01"), categoria);
        Produto produto1 = new Produto("Accer nitro 5", "notebook accer nitro top",
                new BigDecimal("3000.01"), categoria1);
        Produto produto2 = new Produto("Xbox one", "Console da Microsoft",
                new BigDecimal("1500.99"), categoria2);
        Produto produto3 = new Produto("Playstation 4", "Console da Sony",
                new BigDecimal("2500.99"), categoria2);
        Cliente cliente = new Cliente("Pedro Schiavon", "123456789123");
        Cliente cliente1 = new Cliente("Andressa Fernandes", "09876543211");

        EntityManager manager = new DaoUtil().getEntityManager();
        CategoriaDao categoriaDao = new CategoriaDao(manager);
        ProdutoDao produtoDao = new ProdutoDao(manager);
        ClienteDao clienteDao = new ClienteDao(manager);

        manager.getTransaction().begin();
        categoriaDao.inserir(categoria);
        categoriaDao.inserir(categoria1);
        categoriaDao.inserir(categoria2);
        produtoDao.inserir(produto);
        produtoDao.inserir(produto1);
        produtoDao.inserir(produto2);
        produtoDao.inserir(produto3);
        clienteDao.inserir(cliente);
        clienteDao.inserir(cliente1);
        manager.getTransaction().commit();
        manager.close();
    }
}
