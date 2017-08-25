/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicas.web;

import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author JAVA
 */
public class TagSaludo extends SimpleTagSupport {

    private StringWriter sw = new StringWriter();
    private String mensaje;
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        try {
            JspWriter out = getJspContext().getOut();
            getJspBody().invoke(sw);
            out.print("<h2>" + mensaje + " " + sw.toString() + "</h2>");
        } catch (IOException ex) {
            Logger.getLogger(TagSaludo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
