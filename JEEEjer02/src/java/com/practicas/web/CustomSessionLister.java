/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicas.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author JAVA
 */
public class CustomSessionLister implements ServletContextListener, HttpSessionListener {

    private static java.util.HashMap<String,Integer> sessionMap = new java.util.HashMap<String,Integer>();
    private static java.util.HashMap<String,Integer> loginMap = new java.util.HashMap<String,Integer>();
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("sessionCount", sessionMap);
        servletContext.setAttribute("loginCount", loginMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ServletContext servletContext = se.getSession().getServletContext();
        String sessionID = se.getSession().getId();
        if(sessionMap.containsKey(sessionID)){
            sessionMap.put(sessionID, sessionMap.get(sessionID)+1);
        }else{
            sessionMap.put(sessionID, 1);
        }
        servletContext.setAttribute("sessionCount", sessionMap);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
