package br.com.alura.loja.dao;

import br.com.alura.loja.model.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDao {
    private EntityManager manager;

    public CategoriaDao(EntityManager entityManager){
        this.manager = entityManager;
    }

    public void inserir(Categoria categoria){
        manager.persist(categoria);
    }
}
