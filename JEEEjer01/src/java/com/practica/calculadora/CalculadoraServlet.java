/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.calculadora;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JAVA
 */
public class CalculadoraServlet extends HttpServlet {
    
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
            String strNum1 = request.getParameter("num1");
            String strNum2 = request.getParameter("num2");
            String operador = request.getParameter("operador");
            int num1 = 0;
            int num2 = 0;
            int res = 0;
            String msg = null;
            try{
                num1 = new Integer(strNum1);
                num2 = new Integer(strNum2);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
            operador = operador != null ? operador : "+";
            switch(operador){
                case "+" :  res = num1 + num2;
                        break;
                case "-" :  res = num1 - num2;
                        break;
                case "*" :  res = num1 * num2;
                        break;
                case "/" :
                        if(num2 != 0){
                            res = num1 / num2;
                        }else{
                           msg = "Division entre 0."; 
                        }
                        break;
            }
            msg = msg != null ? msg : res + "";
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/calculadora.jsp");
            out.println("<font color='red'>Resultado: " + msg + "</font>");
            rd.include(request, response);
        }catch(Exception e){
            e.printStackTrace();
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
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/calculadora.jsp");
        rd.include(request, response);
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
