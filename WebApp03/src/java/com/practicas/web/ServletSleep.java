/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicas.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JAVA
 */
public class ServletSleep extends HttpServlet {

    public static final Logger logger = Logger.getLogger(ServletSleep.class.getName());
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletSleep</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletSleep at " + request.getContextPath() + "</h1>");
            out.println("<h3>Hilo Principal: " 
                        + "[" + Thread.currentThread().getId() + "] "
                        + Thread.currentThread().getName() );
            out.println("<h3>" + (new java.util.Date()).toString() + "</h3>");
            
            System.out.println("Hilo Principal: " 
                        + "[" + Thread.currentThread().getId() + "] "
                        + Thread.currentThread().getName()
                        + " " + (new java.util.Date()).toString());
            
            final AsyncContext ctxAsy = request.startAsync();
            ctxAsy.setTimeout(12000);
            ctxAsy.addListener(new AsyncListener(){
                @Override
                public void onComplete(AsyncEvent event) throws IOException {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    System.out.println("Complete Async...");
                    System.out.println("Tarea Asincrona terminada " 
                                     + "[" + Thread.currentThread().getId() + "] "
                                     + Thread.currentThread().getName()
                                     + " " + (new java.util.Date()).toString() );
                }

                @Override
                public void onTimeout(AsyncEvent event) throws IOException {
                    //throw new UnsupportedOperationException("Not supported yet.");
                    System.out.println("Timeout Async..." + Thread.currentThread().isInterrupted());
                    System.out.println("Tarea Asincrona interrumpida " 
                                     + "[" + Thread.currentThread().getId() + "] "
                                     + Thread.currentThread().getName()
                                     + " " + (new java.util.Date()).toString() );
                    Thread.currentThread().interrupt();
                }

                @Override
                public void onError(AsyncEvent event) throws IOException {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    System.out.println("Error Async..." + event.toString());
                }

                @Override
                public void onStartAsync(AsyncEvent event) throws IOException {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    System.out.println("Start Async...");
                    System.out.println("Tarea Asincrona iniciada " 
                                     + "[" + Thread.currentThread().getId() + "] "
                                     + Thread.currentThread().getName()
                                     + " " + (new java.util.Date()).toString() );
                }
            });
            
            ctxAsy.start(new Runnable(){
                @Override
                public void run() {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    for(int i=0;i<100;i++){
                        if(Thread.currentThread().isInterrupted()){
                            break;
                        }
                        System.out.println("Hilo Asincrono " 
                                     + "[" + Thread.currentThread().getId() + "] "
                                     + Thread.currentThread().getName()
                                     + " " + (new java.util.Date()).toString() );
                        try{
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            logger.log(Level.SEVERE, null, ex);
                            ex.printStackTrace();
                        }
                    }
                    ctxAsy.complete();
                }
            });
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
