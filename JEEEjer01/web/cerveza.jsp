<%-- 
    Document   : cerveza
    Created on : 21/08/2017, 05:32:31 PM
    Author     : JAVA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= getServletContext().getAttribute("TITULO")%></title>
    </head>
    <body bgcolor="<%= getServletContext().getAttribute("COLOR")%>" >
        <h1><%= getServletContext().getAttribute("HEADER")%></h1>
        <form id="formBeer" action="CervezaServlet" method="POST">
            Selecciona la caracteristica de la cerveza:<br/>
            Tipo:<select name="beerType">
                <option value="Light">Light</option>
                <option value="Clara">Clara</option>
                <option value="Oscura">Oscura</option>
            </select>
            <br/><br/>
            <input type="button" onclick="buscarBeer();" value="Buscar"/>
        </form>
        <script>
            function buscarBeer(){
                document.getElementById("formBeer").submit();
            } 
        </script>
    </body>
</html>
