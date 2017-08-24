<%-- 
    Document   : fruta
    Created on : 24/08/2017, 09:47:35 AM
    Author     : JAVA
--%>

<%@page import="com.practicas.web.Fruta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fruta</title>
    </head>
    <body>
        <jsp:include page="imprimirfecha.jsp" ></jsp:include>
        <h1>Fruta</h1>
        <%
            if(request.getParameter("accion") == null){
                String nombre = "";
                String color = "";
                String sabor = "";
                
                Cookie[] cookies = request.getCookies();
                if(cookies != null){
                    for(Cookie cookie : cookies){
                        if(cookie.getName().equals("nombre_fruta")) nombre = cookie.getValue();
                        if(cookie.getName().equals("color_fruta")) color = cookie.getValue();
                        if(cookie.getName().equals("sabor_fruta")) sabor = cookie.getValue();
                    }
                }
        %>
            <form action="" method="POST">
                <input type="text" name="nombre" value="<%=nombre%>" placeholder="Nombre Fruta" /><br/>
                <br/><input type="text" name="color" value="<%=color%>" placeholder="Color Fruta" /> <br/>
                <br/><input type="text" name="sabor" value="<%=sabor%>" placeholder="Sabor Fruta" /> <br/>
                <br/><input type="submit" name="accion" value="Agregar Fruta" /> <br/>
                <br/><button onclick="document.location.href='index.html'" >Inicio</button> <br/>
            </form>
        <%
            }else{

                java.util.ArrayList frutas = (java.util.ArrayList)session.getAttribute("frutas");
                if(frutas == null){
                    frutas = new java.util.ArrayList();
                }

                Fruta fruta = new Fruta();
                fruta.setId(frutas.size()+1);
                fruta.setNombre(request.getParameter("nombre"));
                fruta.setColor(request.getParameter("color"));
                fruta.setSabor(request.getParameter("sabor"));
                
                frutas.add(fruta);
                session.setAttribute("fruta",fruta);
                session.setAttribute("frutas",frutas);

                Cookie c = new Cookie("nombre_fruta",fruta.getNombre());
                response.addCookie(c);
                c = new Cookie("color_fruta",fruta.getColor());
                response.addCookie(c);
                c = new Cookie("sabor_fruta",fruta.getSabor());
                response.addCookie(c);

        %>
            <h2> <%=fruta.getId()%>. <%=fruta.getNombre()%></h2>
            <h2>Color: <%=fruta.getColor()%></h2>
            <h2>Sabor: <%=fruta.getSabor()%></h2>
            <button onclick="document.location.href='fruta.jsp'" >Nueva Fruta</button>
        <%
            }
        %>    
    </body>
</html>
