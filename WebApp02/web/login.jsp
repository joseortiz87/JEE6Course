<%-- 
    Document   : login
    Created on : 22/08/2017, 10:42:03 AM
    Author     : JAVA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="style.css" ></link>
    </head>
    <body>
        <h1>Login!</h1>
        <form action="login" name="main_form" method="POST" id="main_form" >
            <input name="user" type="text" placeholder="Usuario" />
            <input name="pass" type="password" placeholder="Password" />
            
            <br/><br/>
            <span>Tipo Usuario</span><br/>
            <select name="tipoUsuario">
                <option value="admin">Admin</option>
                <option value="compras">Compras</option>
                <option value="ventas">Ventas</option>
                <option value="invitado">Invitado</option>
            </select>
            <input type="submit" value="Entrar" />
        </form>
        <button onclick="window.location.href='visitas.jsp'" >Visitas</button>
        <button onclick="window.location.href='cookies.jsp'" >Cookies</button>
    </body>
</html>