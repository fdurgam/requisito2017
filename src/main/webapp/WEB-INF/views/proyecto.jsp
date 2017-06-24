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

        <title>Proyectos</title>
    </head>
    <body>
        <div class="container">
            <%@include file="menu.jsp" %>
            <div class="row">
            <div>
            <div class="col-md-4">
            <h4>Detalles de Proyectos</h4>
            </div>
            <div class="col-md-offset-10">
                 <a class="btn btn-primary" href="<spring:url	value="/Proyecto/nuevo"/>">Nuevo</a>
            </div>   
            </div>
                 <table class="table table-striped">          
                <tr> 
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>     
                    <th>Aplicacion</th> 
                </tr>
            <c:forEach  items="${datos}" var="proyecto">
                <tr>       
                    <td>${proyecto.id}</td>   
                    <td>${proyecto.nombreProyecto}</td>
                    <td>${proyecto.descripcionProyecto}</td>
                    <td>${proyecto.aplicacion.id}</td>
                    <td>
                        <a class="btn btn-danger custom-width" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url	value='/Proyecto/eliminar/${proyecto.id}'/>">Eliminar</a>
                        <a class="btn btn-success custom-width" href="<spring:url	value='/Proyecto/update/${proyecto.id}'/>">Editar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
            </div>
        </div>       
    </body>
</html>

