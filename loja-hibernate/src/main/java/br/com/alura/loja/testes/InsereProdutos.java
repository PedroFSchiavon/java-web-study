package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.model.Categoria;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.utils.DaoUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class InsereProdutos {
    public static void main(String[] args) {
        Categoria categoria = new Categoria("NOTEBOOKS");
        Produto produto = new Produto("Notebook", "Accer nitro 5 bom",
                new BigDecimal(800.50f), categoria);

        EntityManager manager = new DaoUtil().getEntityManager();
        manager.getTransaction().begin();
        CategoriaDao categoriaDao = new CategoriaDao(manager);
        categoriaDao.inserir(categoria);
        ProdutoDao produtoDao = new ProdutoDao(manager);
        produtoDao.inserir(produto);
        manager.getTransaction().commit();
        manager.close();

    }
}
