/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicas.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JAVA
 */
public class Login extends HttpServlet {

    private static final String login = "admin";
    private static final String password = "123456";
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
            out.println("<body>");
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
                
                Cookie cookie = new Cookie("usuario",user);
                cookie.setMaxAge(30*60);
                cookie.setComment("Nombre de usuario registrado");
                response.addCookie(cookie);
                
                cookie = new Cookie("color","#81DAF5");
                cookie.setMaxAge(30*60);
                cookie.setComment("Color de area de admin");
                response.addCookie(cookie);
                
                cookie = new Cookie("mensaje","Area de Admin");
                cookie.setMaxAge(30*60);
                response.addCookie(cookie);
                
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
