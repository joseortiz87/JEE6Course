<%-- 
    Document   : error
    Created on : 24/08/2017, 10:28:34 AM
    Author     : JAVA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Algo salio mal!</h1>
        <%@include file="imprimirfecha.jsp" %>
        <h2><%= exception%></h2>
        <img src="https://ril3y.files.wordpress.com/2014/03/exchange-2013-500-error.png" alt="500" />
    </body>
</html>
