package br.com.schiavon;

import java.sql.*;

public class TestaConexao {
    public static void main(String[] args){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection connection = connectionFactory.criaConexao();
        PreparedStatement statement = connection.prepareStatement("insert into PRODUTO (nome, descricao) values ('Cavalo', 'Cavala')")) {
            int updates = statement.executeUpdate();
            System.out.println(updates);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("Fim do update.");
        }


        try(Connection connection = connectionFactory.criaConexao();
            PreparedStatement statement = connection.prepareStatement("select * from PRODUTO");
            ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String descricao = resultSet.getString("descricao");

                    System.out.printf("ID: %d | Nome: %s | Descrição: %s\n", id, nome, descricao);
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("fim do select");
        }



        System.out.println("Conectei alombado!");
    }
}
