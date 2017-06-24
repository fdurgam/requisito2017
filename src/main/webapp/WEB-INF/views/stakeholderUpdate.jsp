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
        <title>Actualizacion Stakeholder</title>
    </head>
    <body>
        <div class="container"> 
            <%@include file="menu.jsp" %> 
            <div class="row">
                <form:form  modelAttribute="updatestakeholder"  class="form-horizontal">
                    <h2 align="center"> Modificar Datos Stakeholder </h2>
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="nombre">Nombre</label>
                        <form:input 	id="nombre"	path="nombre" type="text" class="form:input-large"/>
                    </div>
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="apellido">Apelllido</label>
                        <form:input 	id="apellido"	path="apellido" type="text" class="form:input-large"/>
                    </div>
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="rol">Rol</label>
                        <form:input 	id="rol"	path="rol" type="text" class="form:input-large"/>
                    </div>
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="dni">Dni</label>
                        <form:input 	id="dni"	path="dni" type="text" class="form:input-large"/>
                    </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary col-md-offset-2" value="Actualizar"/>
                        </div>                                        
                </form:form >
            </div>
        </div>
    </body>
</html>