<%-- 
    Document   : gestionRequisitoUpdate
    Created on : 08/06/2017, 17:17:55
    Author     : fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib	prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@	taglib	prefix="form"	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/app.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion Requisitos</title>
         </head>
            <body>
                <div class="container">
                 <%@include file="menu.jsp" %>
                   <table class="table table-striped">   
                       <h4>Aplicacion</h4>
                    <tr>
                        <th>id</th>
                        <th>nombre</th>
                        <th>Descripcion</th>
                    </tr>
                    <tr>
                        <td>${gestion.id}</td>   
                        <td>${gestion.nombre}</td>
                        <td>${gestion.sistemaNombre}</td>            
                    </tr>
                    </table>
                     
                  </div>            
              
   <%-- 
    Detalles asociados
--%>                    
              <div class="container">          
                <table class="table table-striped">    
                    <h4>Proyectos</h4>
                <tr>
                <th>id</th>
                <th>nombre</th>
                <th>Descripcion</th>
                </tr>
                    <c:forEach  items="${gestion.proyectos}" var="proyecto">
                <tr>     
                    <td>${proyecto.id}</td>   
                    <td>${proyecto.nombreProyecto}</td>
                    <td>${proyecto.descripcionProyecto}</td>
                    <td>
                
                          <a class="btn btn-success custom-width" href="<spring:url	value='/Proyectos/Requisitos/${proyecto.id}'/>">Requisitos</a>
                    </td>
                </tr>
                    </c:forEach>
                    </table>
                    </div>                 
                  
    </body>
</html>