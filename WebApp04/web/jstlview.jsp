<%-- 
    Document   : jstlview
    Created on : 24/08/2017, 05:27:00 PM
    Author     : JAVA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat View</title>
    </head>
    <body>
        <h1>Mensaje</h1>
        <sql:query dataSource="jdbc/DS03" var="rs">
            SELECT * FROM chat
            WHERE id = ?
            <sql:param value="${param.id}" />
        </sql:query>
        <c:forEach var="row" items="${rs.rows}" begin="0">
            <c:out value="${row.usuario}" />
            <c:set var="usuario" value="${row.usuario}" />
            <c:set var="mensaje" value="${row.mensaje}" />
            <c:set var="fecha" value="${row.fecha}" />
            <c:set var="owner" value="${row.owner}" />
            <c:set var="id" value="${row.id}" />
        </c:forEach>
        <form action="" method="POST">
            <table>
                <thead>
                    <tr>
                        <th>Campo</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Usuario</td>
                        <td><input type="text" name="usuario" value="${usuario}" /></td>
                    </tr>
                    <tr>
                        <td>Mensaje</td>
                        <td><input type="text" name="mensaje" value="${mensaje}" /></td>
                    </tr>
                    <tr>
                        <td>Fecha</td>
                        <td><input type="text" name="fecha" value="${fecha}" /></td>
                    </tr>
                    <tr>
                        <td>Dominio</td>
                        <td>
                            <input type="text" name="dominio" value="${owner}" />
                            <input type="hidden" name="id" value="${id}" />}
                            <input type="hidden" name="operacion" value="${param.op}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="${fn:toUpperCase(param.op)}" /> 
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
