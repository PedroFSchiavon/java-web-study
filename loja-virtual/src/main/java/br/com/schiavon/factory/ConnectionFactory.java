package br.com.schiavon.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private DataSource dataSource;

    public ConnectionFactory(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mariadb://localhost:3306/loja_virtual");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("superpato97");
        comboPooledDataSource.setMaxPoolSize(15);
        this.dataSource = comboPooledDataSource;
    }
    public Connection criaConexao() throws SQLException {
        return dataSource.getConnection();
    }
}
