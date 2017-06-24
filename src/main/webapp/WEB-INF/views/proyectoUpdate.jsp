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
        <title>Actualizacion Proyecto</title>
    </head>
    <body>
        <div class="container">      
          <%@include file="menu.jsp" %>
          <div class="row">
             <form:form  modelAttribute="updateproyecto"  class="form-horizontal">
             <h2 align="center"> Actualizacion de Proyectos</h2>
              <div class="form-group" >          
                   <label class="control-label col-md-2" for="nombreProyecto">Nombre</label>      
                   <form:input id="nombreProyecto"	path="nombreProyecto" type="text" class="form:input-large"/>
              </div>
              <div class="form-group" >
                   <label class="control-label col-md-2" for="descripcionProyecto">Descripcion</label>  
                    <form:input	id="descripcionProyecto" path="descripcionProyecto" type="text" class="form:input-large"/>
              </div>
              <div class="form-group" >       
                    <label class="control-label col-md-2" for="plan">Aplicacion</label>                          
                    <form:select id="aplicacion" path="aplicacion.id">
                    <form:options items="${aplicaciones}" itemLabel="nombre" itemValue="id"></form:options>
                    </form:select>
                    </div>
                    </div>
                    <div class="form-group">
                      <input type="submit" class="btn btn-primary col-md-offset-2" value="Actualizar"/>
                    </div>     
                </form:form >
            </div>
    </body>
</html>