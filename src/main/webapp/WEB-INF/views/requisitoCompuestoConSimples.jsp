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
                       <h4>Requisito Compuesto</h4>
                    <tr>
                          <th>id</th>
                         <th>nombre</th>
                        <th>necesidad</th>
                        <th>prioriodad</th>
                        <th>riesgo</th>
                        <th>Estado</th>
                    </tr>
                    <tr>
                      <td>${requisitoCompuesto.id}</td>   
                        <td>${requisitoCompuesto.nombre}</td>
                        <td>${requisitoCompuesto.necesidad}</td>
                        <td>${requisitoCompuesto.prioridad}</td> 
                         <td>${requisitoCompuesto.riesgo}</td>
                         <td>${requisitoCompuesto.estado.descripcionEstado}</td>
                        <td>
                          <a class="btn btn-danger custom-width" href="<spring:url value='/RequisitoCompuesto/AgregarNuevoSimple/${requisitoCompuesto.id}'/>">Nuevo Simple</a>
                        </td>
                   </tr>
                    </table>
                     
                  </div>            
              
   <%-- 
    Detalles asociados
--%>                    
              <div class="container">          
                <table class="table table-striped">    
                    <h4>Requisito Simples</h4>
                <tr>
                    <th>ID</th>    
                    <th>nombre</th>
                        <th>necesidad</th>
                        <th>prioriodad</th>
                        <th>Riesgo</th>
                        <th>Estado</th>
                </tr>
                    <c:forEach  items="${requisitoCompuesto.requisitosSimple}" var="requisitoSimple">
                <tr>     
                    <td>${requisitoSimple.id}</td>   
                    <td>${requisitoSimple.nombre}</td>
                    <td>${requisitoSimple.necesidad}</td>
                    <td>${requisitoSimple.prioridad}</td> 
                    <td>${requisitoSimple.riesgo}</td>
                    <td>${requisitoSimple.estado.descripcionEstado}</td>
                    <td>
                         
                    </td>
                </tr>
                    </c:forEach>
                    </table>
                    </div>                 
                  
    </body>
</html>