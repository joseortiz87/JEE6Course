<%-- 
    Document   : jstl
    Created on : 24/08/2017, 02:45:35 PM
    Author     : JAVA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" />
        <title>JSTL</title>
    </head>
    <body>
        <h1>JSP Standard Tag Library</h1>
        <c:if test="${param.action != null}">
            <h2>Formato de Fecha/Hora</h2>
            <c:set var="now" value="<%= new java.util.Date()%>" />
            <ul>
                <li>Hora: <fmt:formatDate type="time" value="${now}" /></li>
                <li>Fecha: <fmt:formatDate type="date" value="${now}" /></li>
                <li>Fecha y Hora: <fmt:formatDate type="both" value="${now}" /></li>
                <li>Fecha y Hora corta: <fmt:formatDate type="both" dateStyle="short" value="${now}" /></li>
                <li>Fecha y Hora larga: <fmt:formatDate type="both" dateStyle="long" value="${now}" /></li>
                <li>Fecha y Hora personalizada: <fmt:formatDate type="both" pattern="yyyy-MM-dd" value="${now}" /></li>
            </ul>
            <h2>Formato Numerico</h2>
            <c:set var="saldo" value="150000.78955" />
            <ul>
                <li>Moneda <fmt:formatNumber type="currency" value="${saldo}" /></li>
                <li>Moneda USD 
                    <fmt:setLocale value="en_US" />
                    <fmt:formatNumber type="currency" value="${saldo}" /></li>
                <li>Moneda Canada 
                    <fmt:setLocale value="fr_CA" />
                    <fmt:formatNumber type="currency" value="${saldo}" /></li>
                <li>Moneda Mexico 
                    <fmt:setLocale value="es_MX" />
                    <fmt:formatNumber type="currency" value="${saldo}" /></li>
                <li>Numerico <fmt:formatNumber type="number" maxFractionDigits="2" value="${saldo}" /></li>
                <li>Porcentaje <fmt:formatNumber type="percent" value="${saldo}" /></li>
                <li>IVA <fmt:formatNumber type="currency" value="${saldo*0.16}" /></li>
                <li>Pattern <fmt:formatNumber type="number" pattern="###.###E0" value="${saldo*100}" /></li>
                <li>Telefono <fmt:formatNumber type="number" pattern="(##) ####-####" value="2224236988" /></li>
            </ul>
            <h2>IF</h2>
            <c:if test="${param.precio<=500}">
                <h3>Precio Bajo</h3>
            </c:if>
            <c:if test="${param.precio>500}">
                <h3>Precio Alto</h3>
            </c:if>
            <h2>CHOOSE</h2>
            <c:choose>
                <c:when test="${param.name == 'naranja'}" >
                    <h3>Fruta Barata</h3>
                </c:when>
                <c:when test="${param.name == 'uva'}" >
                    <h3>Fruta Cara</h3>
                </c:when>
                <c:otherwise>
                    <h3>Sin informacion sobre frutas</h3>
                </c:otherwise>
            </c:choose>
        </c:if>        
        <h2>Funciones de String</h2>          
        <c:set value="4" var="remplazo" />
        <table>
            <thead>
                <tr>
                    <th>Key</th>
                    <th>Value</th>
                    <th>Longitud</th>
                    <th>Mayusculas</th>
                    <th>Remplazo</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${header}" var="h">
                    <tr>
                        <td>${h.key}</td>
                        <td>${h.value}</td>
                        <td>${fn:length(h.value)}</td>
                        <td>${fn:toUpperCase(h.value)}</td>
                        <td>${fn:replace(h.key,'a',remplazo)}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
