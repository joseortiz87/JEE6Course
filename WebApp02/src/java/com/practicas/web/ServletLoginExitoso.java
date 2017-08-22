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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JAVA
 */
public class ServletLoginExitoso extends HttpServlet {

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
            out.println("<title>Login Exitoso</title>");   
            out.println("<link rel=\"stylesheet\" href=\"style.css\" ></link>");
            out.println("</head>");
            
            
            HttpSession session = request.getSession(false);
            if(session.getAttribute("user") != null){
                out.println("<body>");
                out.println("<h1>Servlet ServletLoginExitoso at " + request.getContextPath() + "</h1>");
                out.println("<h2>Bienvenido " + session.getAttribute("user") + "</h2>");
                out.println("<h2>" + session.getAttribute("nombre") + "</h2>");
                out.println("<a href='ServletLogout'>Cerrar Sesion</a>");
                
                String userName = null;
                String cookieId = null;
                Cookie[] cookies = request.getCookies();
                if(cookies != null){
                    out.println("<h2>Cookies</h2>");
                    for(Cookie cookie : cookies){
                       if(cookie.getName().equals("usuario")){
                           userName = cookie.getValue();
                       }
                       if(cookie.getName().equals("JSESSIONID")){
                            cookieId = cookie.getValue();
                       }
                    }
                    out.println("<h3>Usuario: " + userName + "</h3>");
                    out.println("<h3>CookieID: " + cookieId + "</h3>");
                    
                    out.println("<h2>Todas las Cookies</h2>");
                    out.println("<table><thead><tr>"
                        + "<th>Nombre</th><th>Valor</th>"
                        + "<th>Path</th><th>Dominio</th>"
                        + "<th>Age</th><th>Version</th>"
                        + "<th>Comentario</th>"
                        + "</tr></thead><tbody>");
                    for(Cookie cookie : cookies){
                        out.println("<tr>"
                        + "<td>" + cookie.getName() + "</td>"
                        + "<td>" + cookie.getValue() + "</td>"
                        + "<td>" + cookie.getPath()+ "</td>"
                        + "<td>" + cookie.getDomain()+ "</td>"
                        + "<td>" + cookie.getMaxAge()+ "</td>"
                        + "<td>" + cookie.getVersion()+ "</td>"
                        + "<td>" + cookie.getComment()+ "</td>"
                        + "</tr>");
                    }
                    out.println("</tbody></table>");
                }else{
                    out.println("<h2>No Cookies found!</h2>");
                }
                
                Enumeration h = request.getHeaderNames();
                out.println("<h2>Headers</h2>");
                out.println("<ul>");
                while(h.hasMoreElements()){
                    String hname = (String) h.nextElement();
                    out.println("<li><b>Header: </b>" + hname + 
                                " <b>Valor: </b> " + request.getHeader(hname) + "</li>");
                }
                out.println("</ul>");
                
                out.println("</body>");
                out.println("</html>");
            }else{
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
                out.println("<font color='red'>Session no iniciada!</font>");
                rd.include(request, response);
            }
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
        processRequest(request, response);
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