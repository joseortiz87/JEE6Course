<%-- 
    Document   : jstlSqlPool
    Created on : 24/08/2017, 04:39:07 PM
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
        <link rel="stylesheet" href="style.css" />
        <title>Chat</title>
    </head>
    <body>
        <h1>Mensajes Chat!</h1>
        <sql:query dataSource="jdbc/DS03" var="rs">
            SELECT owner FROM chat GROUP BY owner ORDER BY 1
        </sql:query>
        <form action="" method="POST">
            <select name="dominio">
                <c:if test="${rs != null}">
                    <c:forEach var="row" items="${rs.rows}">
                        <option value="${row.owner}">${row.owner}</option>
                    </c:forEach>
                </c:if>
            </select>
            <input type="submit" value="Ver" />
        </form>
        <c:choose>
            <c:when test="${param.dominio != null}" >
                <c:set var="sql" value="SELECT id,owner as dominio,usuario,mensaje,fecha FROM chat 
                       WHERE owner = '${param.dominio}' ORDER BY 2" />
            </c:when>
            <c:otherwise>
                <c:set var="sql" value="SELECT id,owner as dominio,usuario,mensaje,fecha FROM chat 
                       ORDER BY 2" />
            </c:otherwise>
        </c:choose>
        <sql:query dataSource="jdbc/DS03" var="rs">
            ${sql}
        </sql:query>
        <c:if test="${rs != null}">
            <h2>${rs.rowCount} chats localizados</h2>
            <table>
                <thead>
                    <tr>
                        <c:forEach var="colNames" items="${rs.columnNames}">
                            <th>${fn:toUpperCase(colNames)}</th>
                        </c:forEach>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="row" items="${rs.rowsByIndex}">
                        <tr>
                            <c:forEach var="col" items="${row}">
                                <td>${col}</td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>