package br.com.schiavon;

import br.com.schiavon.dao.ProdutoDao;
import br.com.schiavon.model.Produto;

import java.sql.*;
import java.util.List;

public class SelectTest {
    public static void main(String[] args){
        List<Produto> produtos = null;
        try(Connection connection = new ConnectionFactory().criaConexao()){
            ProdutoDao produtoDao = new ProdutoDao(connection);
            produtos = produtoDao.listar();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.out.println("fim do select");
        }

        produtos.forEach(produto -> System.out.println(produto));
    }
}
