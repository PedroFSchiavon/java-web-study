package br.com.schiavon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsersaoTeste {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.criaConexao()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into PRODUTO (nome, descricao) values ('Caneta Azul', 'azul caneta!')",
                    Statement.RETURN_GENERATED_KEYS);
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

