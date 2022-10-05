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

        Produto produto = produtoDao.procurarPorId(1l);
        System.out.println(produto.getNome());

        List<Produto> produtos = produtoDao.procuraTodos();
        produtos.stream().forEach(p -> System.out.println(p.getNome()));

    }

    private static void cadastrarProduto() {
        Categoria categoria = new Categoria("NOTEBOOK");
        Produto produto = new Produto("Accer nitro 5", "Notebook top de ++",
                new BigDecimal("2999.99"), categoria);

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
