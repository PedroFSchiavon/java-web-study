package br.com.schiavon.dao;

import br.com.schiavon.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {
    private Connection connection;

    public ProdutoDao(Connection connection){
        this.connection = connection;
    }

    public void salvar(Produto produto) throws SQLException {
        try (PreparedStatement statement = connection
                .prepareStatement("insert into PRODUTO (nome, descricao) values (?, ?)",
                        Statement.RETURN_GENERATED_KEYS);) {
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getDescricao());
            statement.executeUpdate();

            try(ResultSet generatedKeys = statement.getGeneratedKeys()) {
                while (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    produto.setId(id);
                    System.out.println(produto);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
            System.out.println("ROLLBACK EXECUTADO.");
        } finally {
            System.out.println("Fim do update.");
        }
    }

    public List listar(){
        List<Produto> produtos = new ArrayList<>();
        int id;
        String nome;
        String descricao;
        try(PreparedStatement statement = connection.prepareStatement("select * from PRODUTO");
            ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()){
                id = resultSet.getInt("id");
                nome = resultSet.getString("nome");
                descricao = resultSet.getString("descricao");

                produtos.add(new Produto(id, nome, descricao));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return produtos;
    }
}
