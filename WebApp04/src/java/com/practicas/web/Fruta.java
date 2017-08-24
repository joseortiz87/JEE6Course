package com.practicas.web;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JAVA
 */
public class Fruta implements Serializable{
    private static final long serialVersionUID = 1l;
    private int id;
    private String nombre;
    private String sabor;
    private String color;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "\n" + nombre 
                + "\n Color: " + color
                + "\n Sabor: " + sabor; //To change body of generated methods, choose Tools | Templates.
    }
}
