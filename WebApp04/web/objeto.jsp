<%-- 
    Document   : objeto
    Created on : 24/08/2017, 09:41:26 AM
    Author     : JAVA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! String color_context; %>
<%
    color_context = (String)application.getInitParameter("COLOR_CONTEXTO");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Objetos</title>
        <link rel="stylesheet" href="style.css" />
    </head>
    <body bgcolor="<%= color_context%>">
        <h1>Objetos</h1>
        <%@include file="imprimirfecha.jsp" %>
        <%
            session.setAttribute("uname",request.getParameter("uname"));
            for(int i=1;i<=5;i++){
        %>
            <font color="<%= application.getAttribute("color")%>" size="<%=i%>" >
                <%= session.getAttribute("uname")%>
            </font><br/>
        <%
            } // end for 
        %>
        
        <h2>Cookies</h2>
        <ul>
        <%
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for(Cookie cookie : cookies){
        %>
            <li><%= cookie.getName() %> : <%= cookie.getValue()%></li>
        <%
                }
            }        
        %>
        </ul>
    </body>
</html>
