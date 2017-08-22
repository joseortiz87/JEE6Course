<%-- 
    Document   : invitado
    Created on : 22/08/2017, 01:00:58 PM
    Author     : JAVA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= getServletContext().getAttribute("TITULO_INVITADO") %></title>
    </head>
    <body bgcolor="<%= getServletContext().getAttribute("COLOR_INVITADO") %>">
        <h1><%= getServletContext().getAttribute("MENSAJE_INVITADO") %></h1>
        <%
            int contador = 0;
            session = request.getSession();
            if(session.getAttribute("userCount") != null){
                contador = Integer.parseInt(session.getAttribute("userCount").toString());
                session.setAttribute("userCount", contador++);
            }else{
                session.setAttribute("userCount", 1);
            }
        %>
        <h2><%= contador%></h2>
    </body>
</html>
