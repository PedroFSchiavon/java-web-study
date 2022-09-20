package br.com.schiavon;

import java.sql.*;

public class InsersaoTeste {
    public static void main(String[] args) throws SQLException {
        String nome = "Sorvete'); drop table PRODUTO;";
        String descricao = "SQL Injection.";
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.criaConexao()) {
            PreparedStatement statement = connection
                    .prepareStatement("insert into PRODUTO (nome, descricao) values (?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, nome);
            statement.setString(2, descricao);
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            while (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                System.out.println("Gerei o produto de ID: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Fim do update.");
        }
    }
}

