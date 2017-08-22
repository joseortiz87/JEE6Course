<%-- 
    Document   : admin
    Created on : 22/08/2017, 05:14:54 PM
    Author     : JAVA
--%>

<%@page import="java.util.HashMap" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= getServletContext().getAttribute("TITULO") %></title>
        <link rel="stylesheet" href="style.css" ></link>
    </head>
    <body>
        <h1>Mensaje: <%= getServletContext().getAttribute("MENSAJE") %></h1>
        <h1>Color: <%= getServletContext().getAttribute("COLOR")%></h1>
        <%
            ServletContext context = request.getServletContext();
            HashMap sessionMap = new HashMap();
            sessionMap = (HashMap)context.getAttribute("sessionCount");
            sessionMap = sessionMap != null ? sessionMap : new HashMap();
        %>
        <h2>Conteo de sessiones</h2>
        <table>
            <thead>
                <tr>
                    <th>IDSESSION</th>
                    <th>No. SESSIONES</th>
                </tr>
            </thead>
            <tbody>
                <%
                  for(Object key : sessionMap.keySet()){
                %>
                    <tr>
                        <td><%=((String)key)%></td>
                        <td><%=sessionMap.get(key)%></td>
                    </tr>
                <%
                  }  
                %>
            </tbody>
        </table>
            
        <%
            HashMap loginMap = new HashMap();
            loginMap = (HashMap)context.getAttribute("loginCount");
            loginMap = loginMap != null ? loginMap : new HashMap();
        %>
        <h2>Conteo de usuarios</h2>
        <table>
            <thead>
                <tr>
                    <th>Tipo Usuario</th>
                    <th>No. SESSIONES</th>
                </tr>
            </thead>
            <tbody>
                <%
                  for(Object key : loginMap.keySet()){
                %>
                    <tr>
                        <td><%=((String)key)%></td>
                        <td><%=loginMap.get(key)%></td>
                    </tr>
                <%
                  }  
                %>
            </tbody>
        </table>
    </body>
</html>