package br.com.schiavon;

import java.sql.*;

public class InsersaoTeste {
    public static void main(String[] args) throws SQLException {

        try(Connection connection = new ConnectionFactory().criaConexao()){
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection
                    .prepareStatement("insert into PRODUTO (nome, descricao) values (?, ?)",
                            Statement.RETURN_GENERATED_KEYS);) {
                insereDados("Graveto", "Algo bem comum, por que alguem compraria?", statement);
                insereDados("Diamante", "Algo bem caro para alguem comprar!", statement);

                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();
                System.out.println("ROLLBACK EXECUTADO.");
            } finally {
                System.out.println("Fim do update.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private static void insereDados(String nome, String descricao, PreparedStatement statement) throws SQLException {
        statement.setString(1, nome);
        statement.setString(2, descricao);
        statement.executeUpdate();
        try(ResultSet generatedKeys = statement.getGeneratedKeys()) {
            while (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                System.out.println("Gerei o produto de ID: " + id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

