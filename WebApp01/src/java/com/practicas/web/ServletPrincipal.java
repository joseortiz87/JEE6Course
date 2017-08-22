/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicas.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JAVA
 */
public class ServletPrincipal extends HttpServlet {
    
    private static final String login = "admin";
    private static final String password = "123456";

    @Override
    public void init() throws ServletException {
        System.out.println("Init ServletPrincipal " + (new java.util.Date()).toString() + "...");
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        System.out.println("Destroy ServletPrincipal " + (new java.util.Date()).toString() + "...");
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }
    
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
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPrincipal</title>");            
            out.println("</head>");
            out.println("<body bgcolor='" +
                        getServletContext().getInitParameter("COLOR") + "'>");
            if(user != null && pass != null && login.equals(user) && password.equals(pass)){
                HttpSession session = request.getSession();
                int _default = session.getMaxInactiveInterval();
                int timeout = _default;
                try{
                    timeout = new Integer(getInitParameter("timeout"));
                }catch(NumberFormatException e){
                    e.printStackTrace();
                }
                session.setAttribute("user", user);
                session.setAttribute("nombre", "Usuario Admin Practica");
                session.setAttribute("color", "#292b98");
                if(timeout != _default && timeout > -2){
                    session.setMaxInactiveInterval(timeout);
                }
                //out.println("<h1 style='color:white;'>Bienvenido " + login + "</h1>");
                response.sendRedirect("ServletLoginExitoso");
            }else{
               RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
               out.println("<font color='red'>Error login!</font>");
               rd.include(request, response);
            }
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
        System.out.println("doGet...");
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>GET ServletPrincipal</title>");            
            out.println("</head>");
            out.println("<body bgcolor='" +
                        getInitParameter("color_invitado") + "'>");
            out.println("<h2> Area de " + getInitParameter("rol") + "</h2>");
            out.println("<h3> Hola " + request.getParameter("user") + "</h3>");
            out.println(request.getQueryString());
            
            out.println("<h4>Parametros Contexto Iniciales</h4>");
            Enumeration<String> pi = getServletContext().getAttributeNames();
            out.println("<ul>");
            while(pi.hasMoreElements()){
                out.println("<li>" + pi.nextElement() + "</li>");
            }
            out.println("</ul>");
            
            out.println("<h4>Nivel de Estudio: " + 
                    request.getParameter("estudio") + "</h4>");
            
            out.println("<h4>Vehiculo: " + 
                    request.getParameter("vehiculo") + "</h4>");
            
            out.println("<h4>Hobbies</h4>");
            String [] hobbies = request.getParameterValues("hobbies");
            out.println("<ul>");
            if(hobbies != null){
                for(String hobbie : hobbies){
                    out.println("<li>" + hobbie + "</li>");
                }
            }
            out.println("</ul>");
            
            out.println("<h4>Parametros</h4>");
            pi = request.getParameterNames();
            out.println("<ul>");
            while(pi.hasMoreElements()){
                out.println("<li>" + pi.nextElement() + "</li>");
            }
            out.println("</ul>");
            
            out.println("</body>");
            out.println("</html>");
        }
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
        System.out.println("doPost...");
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
