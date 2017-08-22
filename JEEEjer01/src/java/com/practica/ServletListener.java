/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author JAVA
 */
public class ServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ServletContext context = sce.getServletContext();
        System.out.println("Aplicacion creada en "
                        + context.getContextPath() + " a las "
                        + (new java.util.Date()).toString());
        System.out.println("Server Info "
                + context.getServerInfo());
        context.setAttribute("TITULO", "Cervezas");
        context.setAttribute("HEADER", "Pagina de Seleccion de Cervezas Mexicanas");
        context.setAttribute("COLOR", "#d2effd");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
