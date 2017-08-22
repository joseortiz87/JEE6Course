<%-- 
    Document   : calculadora
    Created on : 21/08/2017, 05:32:15 PM
    Author     : JAVA
--%>

<%
    
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>
    </head>
    <body>
        <form action="CalculadoraServlet" method="POST">
            <input type="number" name="num1" />
            <input type="number" name="num2" />
            
            <br/><br/>
            <span>Operacion</span><br/>
            <input type="radio" name="operador" value="+">+</input><br/>
            <input type="radio" name="operador" value="-">-</input><br/>
            <input type="radio" name="operador" value="*">*</input><br/>
            <input type="radio" name="operador" value="/">/</input><br/>
            
            <input type="submit" />
        </form>
    </body>
</html>
