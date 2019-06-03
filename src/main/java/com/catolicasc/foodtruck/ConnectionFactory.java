/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import com.microsoft.sqlserver.jdbc.SQLServerDriver;

/**
 *
 * @author guilherme
 */
public class ConnectionFactory {
    public Connection getConnection() {
        try {
            String host = "jdbc:mysql://localhost/foodtruck?useTimezone=true&serverTimezone=UTC";
            String user = "user";
            String password = "user";
            Connection connection = DriverManager.getConnection(host, user, password);
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
