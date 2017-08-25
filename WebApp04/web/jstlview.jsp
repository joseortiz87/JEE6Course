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
        <h1>Message ID ${param.id}</h1>
        <ol>
            <c:forEach var="p" items="${param}">
                <li>${p.key} = ${p.value}</li>
            </c:forEach>
        </ol>
        <c:choose>
            <c:when test="${param.op == 'delete'}" >
                    <c:set var="sql"
                           value="DELETE FROM chat WHERE id = '${param.id}'" />
                    <c:set var="msg" value="MENSAJE ELIMINADO" />
                    <c:set var="ac" value="1" />
            </c:when>
            <c:when test="${param.op == 'update' || param.op == 'insert' || param.action != null}" >
                <h2>${param.op}</h2>
            </c:when>
            <c:otherwise>
                <c:set var="msg" value="OPERACION NO VALIDA" />
                <c:set var="ac" value="0" />
            </c:otherwise>
        </c:choose>
        
        <c:choose>
            <c:when test="${ac == 0}">
                <h3>${msg}</h3>
            </c:when>
            <c:when test="${ac == 1}">
                <c:catch var="e">
                    <sql:update dataSource="jdbc/DS03" var="rso">
                        ${sql}
                    </sql:update>
                </c:catch>
                <c:if test="${e != null}">
                    <h3>Ha ocurrido un Error</h3>
                    <div><c:out value="${e}" /></div>
                </c:if>
                <c:if test="${e == null}">
                    <h3>${msg}</h3>
                    <jsp:forward page="jstlSqlPool.jsp" >
                        <jsp:param name="dominio" value="${param.owner}" />
                    </jsp:forward>
                </c:if>
            </c:when>
            <c:when test="${param.action != null}">
                <c:choose>
                    <c:when test="${param.operacion == 'insert'}" >
                        <c:if test="${not empty param.usuario
                              && not empty param.mensaje
                              && not empty param.fecha
                              && not empty param.owner}" >
                            <c:set var="sql"
                                   value="INSERT INTO chat (id,usuario,mensaje,fecha,owner) VALUES
                                   (null,'${param.usuario}','${param.mensaje}',SYSDATE(),'${param.owner}')" />
                            <c:set var="msg" value="MENSAJE INSERTADO" />
                        </c:if>
                    </c:when>
                    <c:when test="${param.operacion == 'update'}" >
                        <c:if test="${not empty param.usuario
                              && not empty param.mensaje
                              && not empty param.fecha
                              && not empty param.owner}" >
                            <c:set var="sql"
                                   value="UPDATE chat SET usuario = '${param.usuario}',
                                   mensaje = '${param.mensaje}', fecha = '${param.fecha}',
                                   owner = '${param.owner}' WHERE id = '${param.id}'" />
                            <c:set var="msg" value="MENSAJE ACTUALIZADO" />
                        </c:if>
                    </c:when>
                </c:choose>
                <c:catch var="e">
                    <sql:update dataSource="jdbc/DS03" var="rs">
                        ${sql}
                    </sql:update>
                </c:catch>
                <c:if test="${e != null}">
                    <h3>Ha ocurrido un Error</h3>
                    <div><c:out value="${e}" /></div>
                </c:if>
                <c:if test="${e == null}">
                    <h3>${msg}</h3>
                    <jsp:forward page="jstlSqlPool.jsp" >
                        <jsp:param name="dominio" value="${param.owner}" />
                    </jsp:forward>
                </c:if>
            </c:when>
            <c:otherwise>
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
                <form action="jstlview.jsp" method="POST">
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
                                    <input type="text" name="owner" value="${owner}" />
                                    <input type="hidden" name="id" value="${id}" />
                                    <input type="hidden" name="operacion" value="${param.op}" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" name="action" value="${fn:toUpperCase(param.op)}" /> 
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>                
            </c:otherwise>
        </c:choose>
    </body>
</html>
