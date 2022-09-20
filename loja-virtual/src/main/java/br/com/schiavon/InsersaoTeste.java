package br.com.schiavon;

import java.sql.*;

public class InsersaoTeste {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.criaConexao()) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection
                    .prepareStatement("insert into PRODUTO (nome, descricao) values (?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            insereDados("Gelo", "Algo bem gelado", statement);
            insereDados("Cha", "Algo bem quente", statement);

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ROLLBACK EXECUTADO.");

        } finally {
            System.out.println("Fim do update.");
        }
    }

    private static void insereDados(String nome, String descricao, PreparedStatement statement) throws SQLException {
        statement.setString(1, nome);
        statement.setString(2, descricao);
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        while (generatedKeys.next()) {
            int id = generatedKeys.getInt(1);
            System.out.println("Gerei o produto de ID: " + id);
        }
    }
}

