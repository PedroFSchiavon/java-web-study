package br.com.alura.loja.testes;

import br.com.alura.loja.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class InsereProdutos {
    public static void main(String[] args) {
        Produto produto = new Produto();
        produto.setNome("Notebook");
        produto.setDescricao("Hp probook muito top");
        produto.setPreco(new BigDecimal(800.50f));

        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("loja-hibernate");
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(produto);
        manager.getTransaction().commit();
    }
}
