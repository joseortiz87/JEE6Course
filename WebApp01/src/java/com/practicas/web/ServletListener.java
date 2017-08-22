/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicas.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author JAVA
 */
public class ServletListener implements ServletContextListener, HttpSessionListener, ServletRequestListener {

    private int totalActiveSessions = 0;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        System.out.println("Aplicacion creada en "
                        + context.getContextPath() + " a las "
                        + (new java.util.Date()).toString());
        System.out.println("Server Info "
                + context.getServerInfo());
        context.setAttribute("ATRIBUTO_INICIAL", "Atributo generado desde context listerner");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //ServletContext context = sce.getServletContext();
        System.out.println("Aplicacion cerrada el "  
                           + (new java.util.Date()).toString());
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        incrementSessions();
        HttpSession session = se.getSession();
        System.out.println("Una nueva sesion ha sido creada " 
                            + (new java.util.Date()).toString());
        System.out.println("Sesiones activas " + getTotalActiveSessions());
        System.out.println(se.toString());
        System.out.println("Session ID created: " + session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        decreaseSessions();
        HttpSession session = se.getSession();
        System.out.println("Una sesion ha sido destruida " 
                            + (new java.util.Date()).toString());
        System.out.println("Sesiones activas " + getTotalActiveSessions());
        System.out.println(se.toString());
        System.out.println("Session ID destruida: " + session.getId());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getTotalActiveSessions() {
        return totalActiveSessions;
    }

    public void setTotalActiveSessions(int totalActiveSessions) {
        this.totalActiveSessions = totalActiveSessions;
    }
    
    private void incrementSessions(){
        totalActiveSessions++;
    }
    
    private void decreaseSessions(){
        totalActiveSessions--;
    }
}
