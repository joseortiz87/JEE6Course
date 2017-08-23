<%-- 
    Document   : profesor
    Created on : 23/08/2017, 10:43:03 AM
    Author     : JAVA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busquedas</title>
        <script>
            function myfn(tipo){
                var formBusqueda = document.getElementById("formBusqueda");
                formBusqueda.action = tipo;
                formBusqueda.submit();
            }
        </script>
    </head>
    <body>
        <h1>Buscar!</h1>
        <form id="formBusqueda" action="ServletPool" method="POST">
            <input type="text" name="nombre" placeholder="Escribe nombre"></input><br/>
            <br/><input type="button" value="Buscar Profesor" onclick="myfn('ServletPool');"></input><br/>
            <br/><input type="button" value="Buscar Alumno" onclick="myfn('ServletJDBC');"></input><br/>
            <br/><input type="button" value="Tarea Asincrona" onclick="myfn('ServletSleep');"></input><br/>
        </form>
    </body>
</html>
