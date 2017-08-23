/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicas.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JAVA
 */
public class ConnectionManager {
    private static final String url = "jdbc:mysql://bd.arcelia.net:3306/bdcolegio02";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "fesalu";
    private static final String password = "bdfes123";
    private static Connection conn;
    
    public static Connection getConnection() throws SQLException{
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        }catch(SQLException e){
            System.out.print("Error de conexion a la DB " + e.getMessage());
            throw e;
        }catch(ClassNotFoundException e){
            System.out.print("No se encontro el driver " + driver + " " + e.getMessage());
            throw new SQLException("No se encontro el driver " + driver + " " + e.getMessage(),e);
        }
        return conn;
    }
}
