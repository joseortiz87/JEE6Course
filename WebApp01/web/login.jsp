<%-- 
    Document   : login
    Created on : 21/08/2017, 12:29:27 PM
    Author     : JAVA
--%>
        <%
            String user = (String)request.getSession().getAttribute("user");
        %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login =)</title>
        <style>
            body{
                color : white;
            }
        </style>
        <script>
            function myFunk(m){
                console.log("Enviando formulario por: " + m);
                document.getElementById("main_form").method = m;
                document.getElementById("main_form").submit();
            }
        </script>
    </head>
    <body bgcolor="<%=getServletContext().getInitParameter("COLOR")%>" >
        <h1>Login!</h1>
        <% if(user != null){ %>
            <h2>Bienvenido: <%= user %></h2>
        <% } %>
        <h2><%= getServletContext().getAttribute("ATRIBUTO_INICIAL")%></h2>
        <form action="ServletPrincipal" name="main_form" method="GET" id="main_form" >
            <input name="user" type="text" placeholder="Nombre Usuario" />
            <input name="pass" type="password" placeholder="Password" />
            
            <br/><br/>
            <span>Nivel de estudio</span><br/>
            <input type="radio" name="estudio" value="Bachillerato">Bachillerato</input><br/>
            <input type="radio" name="estudio" value="Licenciatura">Licenciatura</input><br/>
            <input type="radio" name="estudio" value="Maestria">Maestria</input><br/>
            <input type="radio" name="estudio" value="Doctorado">Doctorado</input><br/>
            
            <br/>
            <span>Hobbies</span><br/>
            <input type="checkbox" name="hobbies" value="Lectura">Lectura</input><br/>
            <input type="checkbox" name="hobbies" value="TV">TV</input><br/>
            <input type="checkbox" name="hobbies" value="Nadar">Nadar</input><br/>
            <input type="checkbox" name="hobbies" value="Cine">Cine</input><br/>
            
            <br/>
            <span>Vehiculo</span><br/>
            <select name="vehiculo">
                <option value="Bicicleta">Bicicleta</option>
                <option value="Moto">Moto</option>
                <option value="Automovil">Automovil</option>
            </select>
            
            <br/><br/>
            <input type="button" value="Entrar con GET" onclick="myFunk('GET')" />
            <input type="button" value="Entrar con POST" onclick="myFunk('POST')" />
        </form>

    </body>
</html>
