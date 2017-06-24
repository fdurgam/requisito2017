<%-- 
    Document   : requisitoCompuestoUpdate
    Created on : 13/06/2017, 15:00:05
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
        <title>Agregar Requisito Compuesto</title>
    </head>
    <body>
       <div class="container">
                 <%@include file="menu.jsp" %>
                   <table class="table table-striped">   
                       <h4>Requisito Compuesto</h4>
                    <tr>
                    <th>Id</th>
                        <th>Nombre</th>
                        <th>Necesidad</th>
                        <th>Prioriodad</th>
                        <th>Riesgo</th>
                        <th>Estado</th>  
                         <th>Proyecto</th>  
                    </tr>
                    <tr>
                        <td>${requisitoCompuesto.id}</td>   
                        <td>${requisitoCompuesto.nombre}</td>
                        <td>${requisitoCompuesto.necesidad}</td>
                        <td>${requisitoCompuesto.prioridad}</td> 
                         <td>${requisitoCompuesto.riesgo}</td>
                         <td>${requisitoCompuesto.estado.descripcionEstado}</td>
                            <td>${requisitoCompuesto.proyecto.id}</td>
                        
                        
                   </tr>
                    </table>
                     
                  </div>            
               <div class="row">
                <form:form  modelAttribute="requisito"  class="form-horizontal">
                    <h2 align="center"> Agregar Requisito Simple </h2>
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="nombre">Nombre</label>
                        <form:input 	id="nombre"	path="nombre" type="text" class="form:input-large"/>
                    </div>
                     <div class="form-group" >
                        <label class="control-label col-md-2" for="necesidad">Necesidad</label>
                        <form:input 	id="necesidad"	path="necesidad" type="text" class="form:input-large"/>
                    </div>
                      <div class="form-group" >
                        <label class="control-label col-md-2" for="prioridad">Prioridad</label>
                        <form:input 	id="prioridad"	path="prioridad" type="text" class="form:input-large"/>
                    </div>
                      <div class="form-group" >
                        <label class="control-label col-md-2" for="riesgo">Riesgo</label>
                        <form:input 	id="riesgo"	path="riesgo" type="text" class="form:input-large"/>
                    </div>
                     
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary col-md-offset-2" value="Aceptar"/>
                        </div>                      
                </form:form >
            </div>
        
        
      
        </div>
    </body>
</html>