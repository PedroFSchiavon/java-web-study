package br.com.alura.loja.dao;

import br.com.alura.loja.model.Produto;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProdutoDao {
    private EntityManager manager;

    public ProdutoDao(EntityManager manager){
        this.manager = manager;
    }

    public void inserir(Produto produto){
        manager.persist(produto);
    }
}
