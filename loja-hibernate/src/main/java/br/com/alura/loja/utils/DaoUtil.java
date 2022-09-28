package br.com.alura.loja.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoUtil {
    private static final EntityManagerFactory MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("loja_hibernate");

    public EntityManager getEntityManager(){
        return MANAGER_FACTORY.createEntityManager();
    }
}
