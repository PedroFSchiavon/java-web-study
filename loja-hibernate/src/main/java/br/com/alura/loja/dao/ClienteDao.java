package br.com.alura.loja.dao;

import br.com.alura.loja.model.Cliente;
import jakarta.persistence.EntityManager;

public class ClienteDao {
    private EntityManager manager;

    public ClienteDao(EntityManager manager){
        this.manager = manager;
    }

    public void inserir(Cliente cliente){
        this.manager.persist(cliente);
    }

    public Cliente procuraPorId(long id){
        return this.manager.find(Cliente.class, id);
    }
}
