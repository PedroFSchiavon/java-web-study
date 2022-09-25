package br.com.schiavon;

import br.com.schiavon.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {
    public static void main(String[] args) {
        String condicao = "gaita";

        ConnectionFactory connectionFactory = new ConnectionFactory();

        try(Connection connection = connectionFactory.criaConexao()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM PRODUTO WHERE nome = ?");
            statement.setString(1, condicao);
            int deletesNumber = statement.executeUpdate();
            System.out.println("Foram executados " + deletesNumber + " DELETES.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("Delete executado");
        }
    }

}
