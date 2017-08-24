<%-- 
    Document   : actiontag
    Created on : 24/08/2017, 12:15:09 PM
    Author     : JAVA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Action Tags</title>
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <h1>Action Tags</h1>
        <jsp:include page="imprimirfecha.jsp"></jsp:include>
        <form action="" method="POST">
            <input type="text" name="nombre" placeholder="Nombre Fruta" /><br/>
            <br/><input type="text" name="color" placeholder="Color Fruta" /> <br/>
            <br/><input type="text" name="sabor" placeholder="Sabor Fruta" /> <br/>
            <br/><input type="submit" name="accion" value="Agregar Fruta" /> <br/>
        </form>
        <br/><button onclick="document.location.href='index.html'" >Inicio</button> <br/>
        <%
            if(request.getParameter("accion") != null){
        %>
            <jsp:useBean id="fruta" class="com.practicas.web.Fruta">
                <jsp:setProperty name="fruta" property="nombre" value="<%= request.getParameter("nombre")%>"></jsp:setProperty>
                <jsp:setProperty name="fruta" property="color" value="<%= request.getParameter("color")%>"></jsp:setProperty>
                <jsp:setProperty name="fruta" property="sabor" value="<%= request.getParameter("sabor")%>"></jsp:setProperty>
            </jsp:useBean>
            <h3><jsp:getProperty name="fruta" property="nombre"></jsp:getProperty></h3>
            <h3>Color: <jsp:getProperty name="fruta" property="color"></jsp:getProperty></h3>
            <h3>Sabor: <jsp:getProperty name="fruta" property="sabor"></jsp:getProperty></h3>
            <%
                session.setAttribute("fruta",fruta);
            %>
            <jsp:forward page="objeto.jsp">
                <jsp:param name="uname" value="<%= fruta.getNombre()%>" />
            </jsp:forward>
        <%
            }
        %>
    </body>
</html>
