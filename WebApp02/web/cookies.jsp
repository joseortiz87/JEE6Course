<%-- 
    Document   : cookies
    Created on : 22/08/2017, 04:05:09 PM
    Author     : JAVA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cookies</title>
        <link rel="stylesheet" href="style.css" ></link>
    </head>
    <body>
        <h1>Enter cookies name & value</h1>
        <form action="addCookie" method="POST" >
            <table>
                <tr>
                    <td>Cookie Name</td>
                    <td>
                        <input type="text" name="cookieName" />
                    </td>
                </tr>
                <tr>
                    <td>Cookie Value</td>
                    <td>
                        <input type="text" name="cookieValue" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Add Cookie" />
                    </td>
                </tr>
            </table>
        </form>
        
        <%
          Cookie[] cookies = request.getCookies();
          if(cookies != null){
        %>
            <h1>Cookies Used so far...</h1>
            <table>
                <thead>
                    <tr>
                        <th>Cookie Name</th>
                        <th>Cookie Value</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for(Cookie cookie : cookies){
                    %>
                        <tr>
                            <td><%= cookie.getName()%></td>
                            <td><%= cookie.getValue()%></td>
                        </tr>
                    <%}%>
                </tbody>
            </table>
        <%}%>
        
    </body>
</html>
