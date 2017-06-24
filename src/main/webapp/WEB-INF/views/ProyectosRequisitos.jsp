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
        <title>Alumno-Datos</title>
    </head>
    <body>
        <div class="container">       
            <%@include file="menu.jsp" %>     
                <h4>Proyecto</h4>
                <table class="table table-striped">     
            <tr> 
                <th>id</th>
                <th>nombre</th>
                <th>Descripcion</th>
            </tr>
            <tr>           
                <td>${proyecto.id}</td>   
                <td>${proyecto.nombreProyecto}</td>
                <td>${proyecto.descripcionProyecto}</td>
               </tr>  
                </table>     
         </div>                 
   <%-- 
    Detalles asociados
   --%>                  
         <div class="container">          
           <table class="table table-striped">   
               <h4>Requisitos</h4>
            <tr>
                <th>id</th>
                <th>nombre</th>
                <th>Necesidad</th>
                <th>Prioridad</th>
                <th>Riesgo</th>
                <th>Estado</th>
            </tr>
            <c:forEach  items="${proyecto.requisitos}" var="requisito">
             <tr>          
                 <td>${requisito.id}</td>   
                 <td>${requisito.nombre}</td>
                 <td>${requisito.necesidad}</td>
                 <td>${requisito.prioridad}</td>            
                 <td>${requisito.riesgo}</td> 
                 <td>${requisito.estado.descripcionEstado}</td>    
                 <td>
                    <a class="btn btn-danger custom-width" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url	value='/Requisito/eliminar/${requisito.id}'/>">Eliminar</a>
                    <a class="btn btn-success custom-width" href="<spring:url	value='/Requisito/update/${requisito.id}'/>">Editar</a>
                    <a class="btn btn-success custom-width" href="<spring:url	value='/Requisito/Estados/${requisito.id}'/>">Estado</a>
                 </td>
                </tr>
                </c:forEach>
                    </table>
                        </div>             
                           </body>
</html>