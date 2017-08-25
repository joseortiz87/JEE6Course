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
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author JAVA
 */
public class Chat {
    private String id;
    private String usuario;
    private String mensaje;
    private String fecha;
    private String owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public void leerChat(){
        try {
            Connection conn = ConnectionManager.getConnection("jdbc/DS03");
            String sql = "SELECT owner,usuario,mensaje,fecha FROM chat " +
                         " WHERE id = '" + this.id + "'";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs =preparedStatement.executeQuery();
            while(rs.next()){
                this.owner = rs.getString(1);
                this.usuario = rs.getString(2);
                this.mensaje = rs.getString(3);
                this.fecha = rs.getString(4);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public JSONObject toJson(){
        JSONObject obj = new JSONObject();
        try {
            obj.put("id", id);
            obj.put("usuario", usuario);
            obj.put("mensaje", mensaje);
            obj.put("fecha", fecha);
            obj.put("owner", owner);
        } catch (JSONException ex) {
            Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
}
