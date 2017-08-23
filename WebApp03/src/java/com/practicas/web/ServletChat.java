/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicas.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JAVA
 */
public class ServletChat extends HttpServlet {

    //public static java.util.ArrayList<String> messages = new java.util.ArrayList<String>();
    private static final String OWNER = "JO031U";
    private static final String JNDI = "jdbc/DS03";
    
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
            out.println("<title>Servlet ServletChat</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletChat at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
        response.setContentType("text/xml");
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            if(request.getParameter("uname") != null){
                session.setAttribute("uname", request.getParameter("uname"));
            }
            String name;
            if(session.getAttribute("uname") != null){
                name = session.getAttribute("uname").toString();
            }else{
                name = "Anonimo";
            }
            if(request.getParameter("newmsg") != null){
                addMenssage(name + ": " + request.getParameter("newmsg"), name);
            }
            if(request.getParameter("clear") != null){
                clearMessages();
            }
            out.println("<chat>");
            listMessages().forEach((msg) -> {
                out.println("<msg>" + msg + "</msg>");
            });
            out.println("</chat>");
            out.close();
        }
    }
    
    public static void addMenssage(String msg,String usuario){
        try (Connection conn = ConnectionManager.getConnection(JNDI)) {
            final String sql = "INSERT INTO chat VALUES (null,?,?,SYSDATE(),?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, usuario);
            st.setString(2, msg);
            st.setString(3, OWNER);
            System.out.println("Executing query..." + sql);
            int rs = st.executeUpdate();
            System.out.println("Se insertaron " + rs + " mensaje/s para el owner " + OWNER);
        } catch (SQLException ex) {
            Logger.getLogger(ServletChat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ServletChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static java.util.ArrayList<String> listMessages(){
        java.util.ArrayList<String> messages = new java.util.ArrayList<>();
        try (Connection conn = ConnectionManager.getConnection(JNDI)) {
            final String sql = "SELECT mensaje FROM chat WHERE owner = '" + OWNER + "'";
            PreparedStatement st = conn.prepareStatement(sql);
            System.out.println("Executing query..." + sql);
            ResultSet rs = st.executeQuery();
            System.out.println("End Executing query...");
            while(rs.next()){
                messages.add(rs.getString("mensaje"));
            }
            for(String msg : messages){
                System.out.println(".: " + msg + " :.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServletChat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ServletChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("End listMessages");
        return messages;
    }
    
    public static void clearMessages(){
        try (Connection conn = ConnectionManager.getConnection(JNDI)) {
            final String sql = "DELETE FROM chat WHERE owner = '" + OWNER + "'";
            PreparedStatement st = conn.prepareStatement(sql);
            System.out.println("Executing query..." + sql);
            int rs = st.executeUpdate();
            System.out.println("Se eliminaron " + rs + " mensajes del owner " + OWNER);
        } catch (SQLException ex) {
            Logger.getLogger(ServletChat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ServletChat.class.getName()).log(Level.SEVERE, null, ex);
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
