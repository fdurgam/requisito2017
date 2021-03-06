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
            <div class="row">
                <form:form  modelAttribute="updaterequisitocompuesto"  class="form-horizontal">
                    <h2 align="center"> Agregar Requisito Compuesto</h2>
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
            <div class="form-group" >
                        <label class="control-label col-md-2" for="plan">Proyecto</label>                  
                        <form:select id="proyecto" path="proyecto.id">
                            <form:options items="${proyectos}" itemLabel="nombreProyecto" itemValue="id"></form:options>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary col-md-offset-2" value="Aceptar"/>
                    </div>                        
                </form:form >
            </div>
            
            <div class="container">          
                <table class="table table-striped">    
                    <h4>Requisito Simples</h4>
                <tr>
                 <th>nombre</th>
                        <th>necesidad</th>
                        <th>prioriodad</th>
                        <th>riesgo</th>
                        <th>Estado</th>
                </tr>
                    <c:forEach  items="${updaterequisitocompuesto.requisitosSimple}" var="requisitoSimple">
                <tr>     
                    <td>${requisitoSimple.id}</td>   
                    <td>${requisitoSimple.nombre}</td>
                    <td>${requisitoSimple.necesidad}</td>
                    <td>${requisitoSimple.prioridad}</td> 
                         <td>${requisitoSimple.riesgo}</td>
                         <td>${requisitoSimple.estado.descripcionEstado}</td>
                    
                </tr>
                    </c:forEach>
                    </table>
                    </div> 
        </div>
    </body>
</html>