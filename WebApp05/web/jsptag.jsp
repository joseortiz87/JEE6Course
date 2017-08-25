<%-- 
    Document   : jsptag
    Created on : 25/08/2017, 10:50:41 AM
    Author     : JAVA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="WEB-INF/tlds/customtag_library.tld" prefix="ex" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Custom Tag</title>
    </head>
    <body>
        <h1>Custom Tags</h1>
        <ex:HelloTag />
        
        <form action="" method="POST">
            <input type="text" name="mensaje" placeholder="Mensaje" />
            <input type="text" name="curp" placeholder="Ingresa CURP" />
            
            <h2>Mostrar Campos</h2><br/>
            <input type="checkbox" name="showNombre" value="true" >Nombre</input><br/>
            <input type="checkbox" name="showProfesion" value="true" >Profesion</input><br/>
            <input type="checkbox" name="showCelular" value="true" >Celular</input><br/>
            <input type="checkbox" name="showEmail" value="true" >Email</input><br/>
            <br/><input type="submit" value="Buscar" />
        </form>
        <c:if test="${not empty param.curp}" >
            <ex:TagSaludo mensaje="${param.mensaje}">${param.curp}</ex:TagSaludo>
        </c:if>
        
        <ex:ProfesorTag curp="${param.curp}" 
                        showNombre="${param.showNombre}" 
                        showProfesion="${param.showProfesion}" 
                        showCelular="${param.showCelular}" 
                        showEmail="${param.showEmail}" ></ex:ProfesorTag>
    </body>
</html>
