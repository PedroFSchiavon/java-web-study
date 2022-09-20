package br.com.schiavon;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        try(Connection connection = connectionFactory.criaConexao()){
            Statement statement = connection.createStatement();
            int deletesNumber = statement.executeUpdate("DELETE FROM PRODUTO WHERE nome = 'caneta'");
            System.out.println("Foram executados " + deletesNumber + " DELETES.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("Delete executado");
        }
    }

}
