package br.com.alura.loja.dao;

import br.com.alura.loja.model.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDao {
    private EntityManager manager;

    public CategoriaDao(EntityManager entityManager){
        this.manager = entityManager;
    }

    public void inserir(Categoria categoria){
        this.manager.persist(categoria);
    }

    public void atualizar(Categoria categoria){
        this.manager.merge(categoria);
    }

    public void remover(Categoria categoria){
        categoria = this.manager.merge(categoria);
        this.manager.remove(categoria);
    }
}
