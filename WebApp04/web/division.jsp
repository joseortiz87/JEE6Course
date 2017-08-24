<%-- 
    Document   : division
    Created on : 24/08/2017, 09:47:26 AM
    Author     : JAVA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Division</title>
    </head>
    <body>
        <h1>Division!</h1>
        <form>
            <input type="text" name="n1" placeholder="Ingresa N1" />
            <input type="text" name="n2" placeholder="Ingresa N2" />
            <input type="submit" name="accion" value="Dividir" />
        </form>
        <%
            if(request.getParameter("accion") != null){
                int a = Integer.parseInt(request.getParameter("n1"));
                int b = Integer.parseInt(request.getParameter("n2"));
                int c = a/b;
                out.println("<h2>Resultado: " + c + "</h2>");
            }
        %>
    </body>
</html>
