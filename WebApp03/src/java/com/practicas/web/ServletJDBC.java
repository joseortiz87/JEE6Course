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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JAVA
 */
public class ServletJDBC extends HttpServlet {

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
            out.println("<title>Alumnos JDBC</title>"); 
            out.println("<link rel=\"stylesheet\" href=\"style.css\" ></link>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Alumnos " + request.getContextPath() + "</h1>");
            
            try{
                Connection conn = ConnectionManager.getConnection();
                if(conn == null){
                    out.println("<font color='red'>Error de conexion...</font>");
                    //throw new SQLException("Error de conexion jdbc/DS03...");
                }else{
                    String nombre = request.getParameter("nombre");
                    String sql = "SELECT * FROM alumnos";
                    if(nombre != null){
                        sql += " WHERE CONCAT_WS(' ',nombre,ap_paterno,ap_materno) "
                            + " LIKE '%" + nombre + "%'";
                    }
                    out.println("<table><thead>"
                        + "<tr>"
                        + "<th>Nombre</th><th>Paterno</th><th>Materno</th><th>CURP</th>"
                        + "</tr></thead><tbody>");

                    PreparedStatement st = conn.prepareStatement(sql);
                    ResultSet rs = st.executeQuery();
                    while(rs.next()){
                        out.println("<tr>"
                                + "<td>" + rs.getString("nombre") + "</td>"
                                + "<td>" + rs.getString("ap_paterno") + "</td>"
                                + "<td>" + rs.getString("ap_materno") + "</td>"
                                + "<td>" + rs.getString("curp") + "</td>"
                                + "</tr>");
                    }

                    out.println("</tbody></table>");
                    conn.close();
                }
            }catch (SQLException ex) {
                out.println("<font color='red'>Error SQL : " + ex.getMessage() + "</font>");
                Logger.getLogger(ServletPool.class.getName()).log(Level.SEVERE, null, ex);
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
