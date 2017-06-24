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
        <title>Requisitos Stakeholder</title>
    </head>
    <body>
        <div class="container">
            <%@include file="menu.jsp" %>
            <h4>Stakeholder</h4>
            <table class="table table-striped">       
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Rol</th>
                    <th>Dni</th>
                </tr>
                <tr>  
                   <td>${stakeholder.id}</td>   
                   <td>${stakeholder.nombre}</td>
                   <td>${stakeholder.apellido}</td>
                   <td>${stakeholder.rol}</td>
                   <td>${stakeholder.dni}</td> 
                   
                       </td>
                </tr>
           
                 </table>            
         </div>            
              
   <%-- Detalles asociados --%>    
              <div class="container">          
                <table class="table table-striped">   
                    <h4>Requisito del Stakeholder</h4>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Necesidad</th>
                <th>Prioridad</th>
                <th>Riesgo</th>
                <th>Estado</th> 
                
            </tr>
                    <c:forEach  items="${stakeholder.requisitos}" var="requisito">
                <tr>                    
                   <td>${requisito.id}</td>   
                   <td>${requisito.nombre}</td> 
                   <td>${requisito.necesidad}</td> 
                   <td>${requisito.prioridad}</td> 
                   <td>${requisito.riesgo}</td> 
                   <td>${requisito.estado.descripcionEstado}</td>                    
                   <td>
                       <a class="btn btn-danger custom-width" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url	value='/Proyecto/eliminar/${requisito.id}'/>">Eliminar</a>
                       <a class="btn btn-success custom-width" href="<spring:url	value='/Proyecto/update/${requisito.id}'/>">Editar</a>     
                   </td>
                </tr>
                    </c:forEach>
                     </table>
              </div>                      
                   
    </body>
</html>
