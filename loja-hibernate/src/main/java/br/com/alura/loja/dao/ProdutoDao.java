package br.com.alura.loja.dao;

import br.com.alura.loja.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class ProdutoDao {
    private EntityManager manager;

    public ProdutoDao(EntityManager manager){
        this.manager = manager;
    }

    public void inserir(Produto produto){
        this.manager.persist(produto);
    }
    
    public void atualizar(Produto produto){
        this.manager.merge(produto);
    }
    
    public void remove(Produto produto){
        produto = this.manager.merge(produto);
        this.manager.remove(produto);
    }

    public Produto procurarPorId(long id){
        return this.manager.find(Produto.class, id);
    }

    public List<Produto> procuraTodos(){
        String jpql = "SELECT p from Produto as p";
        return Collections.unmodifiableList(this.manager.createQuery(jpql, Produto.class).getResultList());
    }

    public List<Produto> procurarPorNome(String nome){
        String jpql = "SELECT p from Produto as p WHERE p.nome = ?1";
        return Collections.unmodifiableList(this.manager.createQuery(jpql, Produto.class)
                .setParameter(1, nome).getResultList());
    }

    public List<Produto> procurarPorCategoria(String categoria){
        String jpql = "SELECT p from Produto as p WHERE p.categoria.nome = :categoria";
        return Collections.unmodifiableList(this.manager.createQuery(jpql, Produto.class)
                .setParameter("categoria", categoria).getResultList());
    }

    public BigDecimal procurarPrecoPorNome(String nome){
        String jpql = "SELECT p.preco from Produto as p WHERE p.nome = ?1";
        return this.manager.createQuery(jpql, BigDecimal.class)
                .setParameter(1, nome)
                .getSingleResult();
    }

    public List<Produto> parametrosDinamicos(String nome, BigDecimal preco, LocalDate localDate){
        String jpql = "SELECT p FROM Produto p WHERE 1=1";

        if(nome != null && !nome.trim().isEmpty())
            jpql += " AND p.nome = :nome";
        if(preco != null)
            jpql += " AND p.preco = :preco";
        if(localDate != null)
            jpql += " AND p.localDate = :localDate";

        TypedQuery<Produto> query = manager.createQuery(jpql, Produto.class);
        if(nome != null && !nome.trim().isEmpty())
            query.setParameter("nome", nome);
        if(preco != null)
            query.setParameter("preco", preco);
        if(localDate != null)
            query.setParameter("localDate", localDate);
        return query.getResultList();
    }
}
