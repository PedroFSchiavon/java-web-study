package br.com.schiavon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection criaConexao() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/loja_virtual";
        String user = "root";
        String password = "superpato97";
        return DriverManager.getConnection(url, user, password);
    }
}
