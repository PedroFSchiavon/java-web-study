package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.model.Categoria;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.utils.DaoUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class InsereProdutos {
    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager manager = new DaoUtil().getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(manager);
//
//        Produto produto = produtoDao.procurarPorId(1l);
//        System.out.println(produto.getNome());
//
//        List<Produto> produtos = produtoDao.procuraTodos();
//        produtos.stream().forEach(p -> System.out.println(p.getNome()));
//
//        List<Produto> accer = produtoDao.procurarPorNome("Accer nitro 5");
//        accer.stream().forEach(a -> System.out.println(a.getNome() + " -- " + a.getLocalDate()));

        List<Produto> categoria = produtoDao.procurarPorCategoria("CELULAR");
        categoria.stream().forEach(c -> System.out.println(c.getNome() + "----------" + c.getDescricao()));


    }

    private static void cadastrarProduto() {
        Categoria categoria = new Categoria("CELULAR");
        Produto produto = new Produto("Moto e5", "Motorola ja foi bão",
                new BigDecimal("999.99"), categoria);

        EntityManager manager = new DaoUtil().getEntityManager();
        CategoriaDao categoriaDao = new CategoriaDao(manager);
        ProdutoDao produtoDao = new ProdutoDao(manager);

        manager.getTransaction().begin();
        categoriaDao.inserir(categoria);
        produtoDao.inserir(produto);
        manager.getTransaction().commit();
        manager.close();
    }
}
