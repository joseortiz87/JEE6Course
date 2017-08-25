/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicas.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author JAVA
 */
public class Profesor {
    private String nombre_profesor;
    private String curp;
    private String email;
    private String profesion;
    private String celular;
    
    public void leerProfesor(){
        try {
            setNombre_profesor("");
            Connection conn = ConnectionManager.getConnection("jdbc/DS03");
            String sql = "SELECT CONCAT_WS(' ',nombres,apellido_p,apellido_m) as nombre,"
                    + " email,profesion,celular"
                    + " FROM profesor"
                    + " WHERE curp = '" + this.curp + "'";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs =preparedStatement.executeQuery();
            while(rs.next()){
                this.nombre_profesor = rs.getString(1);
                this.email = rs.getString(2);
                this.profesion = rs.getString(3);
                this.celular = rs.getString(4);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNombre_profesor() {
        return nombre_profesor;
    }

    public void setNombre_profesor(String nombre_profesor) {
        this.nombre_profesor = nombre_profesor;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
}
