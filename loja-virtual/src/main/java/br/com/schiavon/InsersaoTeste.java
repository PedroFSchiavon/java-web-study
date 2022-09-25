package br.com.schiavon;

import br.com.schiavon.dao.ProdutoDao;
import br.com.schiavon.factory.ConnectionFactory;
import br.com.schiavon.model.Produto;

import java.sql.*;

public class InsersaoTeste {
    public static void main(String[] args){
        Produto produto = new Produto("Batedeira", "Batedeira planetaria vermelha", 2);

        try(Connection connection = new ConnectionFactory().criaConexao()){
            connection.setAutoCommit(false);
            ProdutoDao produtoDao = new ProdutoDao(connection);
            produtoDao.salvar(produto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

