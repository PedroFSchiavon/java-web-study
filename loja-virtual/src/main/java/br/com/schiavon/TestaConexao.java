package br.com.schiavon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/loja_virtual";
        String user = "root";
        String password = "superpato97";
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println("Conectei alombado!");
        connection.close();
    }
}
