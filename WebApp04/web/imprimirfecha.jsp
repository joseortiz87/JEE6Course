<%-- 
    Document   : imprimirfecha
    Created on : 24/08/2017, 09:41:15 AM
    Author     : JAVA
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- Uso de expresion jsp --%>
<h2>Hoy es <%= java.util.Calendar.getInstance().getTime() %></h2>
<%
    Date dnow = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.d ' a las ' hh:mm:ss a zzz");
    out.print("<h3>" + ft.format(dnow) + "</h3>");
    
    session.setAttribute("fecha",ft.format(dnow));
    application.setAttribute("color", "green");
    application.setInitParameter("sitio", "http://www.google.com");
    
    if(request.getParameter("uname") != null){
%>
    <h1>Hola <%= request.getParameter("uname") %> !</h1>
<% } %>