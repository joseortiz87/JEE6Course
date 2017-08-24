<%-- 
    Document   : el
    Created on : 24/08/2017, 12:47:30 PM
    Author     : JAVA
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL</title>
    </head>
    <body>
        <h1>EL!</h1>
        <h2>Session</h2>
        <ul>
            <li>Fecha ${sessionScope.fecha}</li>
            <li>Fruta ${sessionScope.fruta.nombre}</li>
            <li>Color Fruta ${sessionScope.fruta.color}</li>
            <li>Sabor Fruta ${sessionScope.fruta.sabor}</li>
        </ul>
        <h2>Application</h2>
        <ul>
            <li>Color ${applicationScope.color}</li>
            <li>Sitio ${initParam.sitio}</li>
        </ul>
        <h2>Cookies</h2>
        <ul>
            <li>Fruta ${cookie.nombre_fruta.value}</li>
            <li>Color Fruta ${cookie.color_fruta.value}</li>
            <li>Sabor Fruta ${cookie.sabor_fruta.value}</li>
        </ul>
        <h2>Todas las Cookies</h2>
        <ul>
            <c:if test="${cookie != null}">
                <c:forEach var="cookies" items="${cookie}">
                    <li>
                        <c:out value="${cookies.key}" /> : 
                        Cookie = <c:out value="${cookies.value}" />
                        Valor = <c:out value="${cookies.value.value}" />
                    </li>
                </c:forEach>
            </c:if>
        </ul>
        <h2>Parametros</h2>
        <ul>
            <c:if test="${param.uname != null}">
                <li>Nombre: ${param.uname}</li>
                <li>Nombre: ${param["uname"]}</li>
            </c:if>
            <c:if test="${param.uname == null}">
                <li>No existe un parametro nombre</li>
            </c:if>
        </ul>
        <h2>Header</h2>
        <ul>
            <li>User Agent ${header["user-agent"]}</li>
            <li>Acept Encoding ${header["Accept-Encoding"]}</li>
        </ul>
        <h2>Operaciones</h2>
        <ul>
            <li>1 es mayor que 2 ${1>2}</li>
            <li>1 + 2 + 3 = ${1+2+3}</li>
            <li>N1 * N2 = ${param.n1 + param.n2}</li>
        </ul>
        <%
            List nombres = new ArrayList();
            nombres.add("Juan");
            nombres.add("Pedro");
            nombres.add("Maria");
            pageContext.setAttribute("nombres", nombres);
        %>
        <h2>Nombres</h2>
        <ul>
            <c:forEach var="nombre" items="${nombres}">
                <li><c:out value="${nombre}" /></li>
            </c:forEach>
        </ul>
        <h2>Varios</h2>
        <ul>
            <li>COLOR_CONTEXTO ${initParam.COLOR_CONTEXTO}</li>
            <li>Metodo de acceso ${pageContext.request.method}</li>
        </ul>
    </body>
</html>
