<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib	prefix="spring"	uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/app.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Stakeholders</title>
    </head>
    <body>
        <div class="container">
            <%@include file="menu.jsp" %>
            <div class="row">
                <div >
                    <div class="col-md-4">
                        <h4>Stakeholders</h4>              
                    </div>
                    <div class="col-md-offset-10">
                        <a class="btn btn-primary" href="<spring:url	value="/Stakeholder/nuevo"/>"  >Nuevo</a>
                    </div>   
                </div>
                 <table class="table table-striped">        
                 <tr>
                      <th>id</th>
                      <th>nombre</th>
                      <th>apellido</th>
                      <th>Rol</th>
                      <th>DNI</th>
                </tr>
                    <c:forEach  items="${datos}" var="stakeholder">
                    <tr>               
                    <td>${stakeholder.id}</td>   
                    <td>${stakeholder.nombre}</td>
                    <td>${stakeholder.apellido}</td>
                    <td>${stakeholder.rol}</td>
                    <td>${stakeholder.dni}</td>             
                    <td>
                      <a class="btn btn-danger custom-width" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url	value='/Stakeholder/eliminar/${stakeholder.id}'/>">Eliminar</a>
                      <a class="btn btn-success custom-width" href="<spring:url	value='/Stakeholder/update/${stakeholder.id}'/>">Editar</a>
                      <a class="btn btn-success custom-width" href="<spring:url	value='/Stakeholder/Requisito/${stakeholder.id}'/>">Requisitos</a>
                    </td>
                    </tr>
                    </c:forEach>
                </table>          
            </div>
        </div>       
    </body>
</html>