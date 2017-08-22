<%-- 
    Document   : visitas
    Created on : 22/08/2017, 02:56:16 PM
    Author     : JAVA
--%>

<%@page import="java.util.HashMap" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visitas</title>
        <link rel="stylesheet" href="style.css" ></link>
    </head>
    <body>
        <h1>Visitas!</h1>
        <%
            ServletContext context = request.getServletContext();
            HashMap urls = new HashMap();
            urls = (HashMap)context.getAttribute("estadistica");
            urls = urls != null ? urls : new HashMap();
        %>
        <table>
            <thead>
                <tr>
                    <th>Pagina</th>
                    <th>No. Visitas</th>
                </tr>
            </thead>
            <tbody>
                <%
                  for(Object key : urls.keySet()){
                %>
                    <tr>
                        <td><%=((String)key)%></td>
                        <td><%=urls.get(key)%></td>
                    </tr>
                <%
                  }  
                %>
            </tbody>
        </table>
    </body>
</html>
