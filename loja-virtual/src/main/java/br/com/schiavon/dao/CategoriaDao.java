package br.com.schiavon.dao;

import br.com.schiavon.model.Categoria;
import br.com.schiavon.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {
    private Connection connection;

    public CategoriaDao(Connection connection){
        this.connection = connection;
    }

    public List<Categoria> listar(){
        List<Categoria> categorias = new ArrayList<>();
        String sql = "select * from CATEGORIA";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.executeQuery();
            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    categorias.add(new Categoria(resultSet.getInt(1), resultSet.getString(2)));
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return categorias;
    }

    public List<Categoria> listarComProduto(){
        Categoria ultima = null;
        List<Categoria> categoriasComProdutos = new ArrayList<>();
        String sql = "select c.id, c.nome, p.id, p.nome, p.descricao " +
                "from CATEGORIA c inner join PRODUTO p on c.id = p.id_categoria order by c.id";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.executeQuery();
            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    if(ultima == null || !ultima.getNome().equals(resultSet.getString(2))){
                        ultima = new Categoria(resultSet.getInt(1), resultSet.getString(2));
                    }
                    Produto produto = new Produto(resultSet.getInt(3), resultSet.getString(4),
                            resultSet.getString(5));
                    ultima.setProdutos(produto);

                    System.out.println(ultima.getNome());
                    categoriasComProdutos.add(ultima);
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return categoriasComProdutos;
    }
}
