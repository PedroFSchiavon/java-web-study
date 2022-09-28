package br.com.alura.loja.testes;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.enuns.Categoria;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.utils.DaoUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class InsereProdutos {
    public static void main(String[] args) {
        Produto produto = new Produto("Notebook", "Accer nitro 5 bom",
                new BigDecimal(800.50f), Categoria.ELETRONICO);

        EntityManager manager = new DaoUtil().getEntityManager();
        manager.getTransaction().begin();
        ProdutoDao produtoDao = new ProdutoDao(manager);
        produtoDao.inserir(produto);
        manager.getTransaction().commit();

    }
}
