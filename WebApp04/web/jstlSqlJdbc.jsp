<%-- 
    Document   : jstlSqlJdbc
    Created on : 24/08/2017, 03:44:26 PM
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
        <title>JSTL + SQL + JDBC</title>
    </head>
    <body>
        <h1>Alumnos</h1>
        <sql:setDataSource var="conn" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://bd.arcelia.net:3306/bdcolegio02"
                           user="fesalu" password="bdfes123"/>
        <sql:query dataSource="${conn}" var="rs">
            SELECT clave_alu,nombre,ap_paterno,ap_materno,curp
            FROM alumnos
            <c:if test="${param.name != null}">
                WHERE nombre = ?
                <sql:param value="${param.name}" />
            </c:if>
        </sql:query>
        <c:if test="${rs != null}">
            <h2>${rs.rowCount} alumnos localizados</h2>
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
