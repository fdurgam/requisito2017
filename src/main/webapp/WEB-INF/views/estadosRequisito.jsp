<%-- 
    Document   : estadosRequisito
    Created on : 13/06/2017, 12:10:29
    Author     : fernando
--%>

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

        <title>Estados Requisito</title>
    </head>
    <body>
        <div class="container">
            <%@include file="menu.jsp" %>
            <div class="row">
                <div>
                <div class="col-md-4">
                     <h4>Todos los Estados</h4>
                     <h4>Cantidad ${cantidad}</h4>
                     </div>
                     <div class="col-md-offset-10">
                        <a class="btn btn-primary" href="<spring:url	value="/Proyecto/nuevo"/>"  >Nuevo</a>
                     </div> 
                </div>
                 <table class="table table-striped"> 
                    <tr>
                    <th>id</th>
                    <th>Descripcion</th>
                    </tr>
                        <c:forEach  items="${datos}" var="estado">
                    <tr> 
                        <td>${estado.id}</td>   
                        <td>${estado.descripcionEstado}</td>
                        <td>
                           <a class="btn btn-danger custom-width" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url	value='/Proyecto/eliminar/${estado.id}'/>">Eliminar</a>
                           <a class="btn btn-success custom-width" href="<spring:url	value='/Proyecto/update/${estado.id}'/>">Editar</a>
                       </td>
                </tr>
                        </c:forEach>
                </table>
            </div>
        </div>        
        </body>
</html>
