/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicas.web;

import java.io.IOException;
import java.io.StringWriter;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author JAVA
 */
public class ProfesorTag extends SimpleTagSupport {

    private String curp;
    private Boolean showNombre;
    private Boolean showEmail;
    private Boolean showProfesion;
    private Boolean showCelular;
    private StringWriter sw = new StringWriter();
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if(curp == null || curp.isEmpty() || curp.length() < 3){
            out.print("<h2>CURP invalida</h2>"); 
        }else{
            Profesor profesor = new Profesor();
            profesor.setCurp(curp);
            profesor.leerProfesor();
            if(profesor.getNombre_profesor() == null || profesor.getNombre_profesor().isEmpty()){
               out.print("<h2>No se encontraron datos para el curp: " + curp + "</h2>"); 
            }else{
                System.out.print("showNombre: " + showNombre);
                System.out.print("showEmail: " + showEmail);
                System.out.print("showProfesion: " + showProfesion);
                System.out.print("showCelular: " + showCelular);
                
                StringBuilder str = new StringBuilder();
                out.print("<h2>" + curp + "</h2>");
                str.append("<ul>");
                if(showNombre != null && showNombre){
                    str.append("<li>Nombre: ").append(profesor.getNombre_profesor()).append("</li>");
                }
                
                if(showEmail != null && showEmail){
                   str.append("<li>Email: ").append(profesor.getEmail()).append("</li>"); 
                }
                
                if(showProfesion != null && showProfesion){
                    str.append("<li>Profesion: ").append(profesor.getProfesion()).append("</li>"); 
                }
               
                if(showCelular != null && showCelular){
                    str.append("<li>Celular: ").append(profesor.getCelular()).append("</li>");
                }
                str.append("</ul>");
                out.print(str.toString());
            }
        }
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public void setShowNombre(Boolean showNombre) {
        this.showNombre = showNombre;
    }

    public void setShowEmail(Boolean showEmail) {
        this.showEmail = showEmail;
    }

    public void setShowProfesion(Boolean showProfesion) {
        this.showProfesion = showProfesion;
    }

    public void setShowCelular(Boolean showCelular) {
        this.showCelular = showCelular;
    }
}
