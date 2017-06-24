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
        <title>Estado Requisito</title>
    </head>
    <body>
        <div class="container">         
            <%@include file="menu.jsp" %>
             <div class="container">                  
              <table class="table table-striped">
                  <h4>Requisito</h4>
               <tr>   
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Estado</th> 
                    <th>Proyecto</th> 
                </tr>
                <tr>          
                    <td>${requisito.id}</td>   
                    <td>${requisito.nombre}</td>
                    <td>${requisito.nombre}</td>
                    <td>${requisito.estado.descripcionEstado}</td>
                     <td>${requisito.proyecto.id}</td>
                    <td></td>
                </tr>
                   </table>
                
  <%-- detalle--%>                 
                   <div class="container">          
                     <table class="table table-striped"> 
                         <h4>Cambio de Estado</h4>
                        <tr>
                            <th>Descripcion</th>
                        </tr>
                            <c:forEach  items="${siguientes}" var="estado">
                        <tr>           
                            <td>${estado.descripcionEstado}</td>
                            <td>
                                <a class="btn btn-success custom-width" href="<spring:url	value='/Requisito/${estado.descripcionEstado}/${requisito.id}'/>">Cambiar</a>
                            </td>
                        </tr>
                            </c:forEach>
                      </table>            
              </div>                
         </div>            
    </body>
</html>
