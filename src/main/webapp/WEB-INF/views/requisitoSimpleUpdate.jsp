<%-- 
    Document   : requistoform
    Created on : 12/06/2017, 11:20:32
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
        <title>Actualizacion Requisito Simple</title>
    </head>
    <body>
        <div class="container"> 
            <%@include file="menu.jsp" %>        
            <div class="row">
                <form:form  modelAttribute="updaterequisitosimple"  class="form-horizontal">
                    <h2 align="center"> Agregar Requisito </h2>
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
        </div>
    </body>
</html>
