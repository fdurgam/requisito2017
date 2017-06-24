<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib	prefix="spring"	uri="http://www.springframework.org/tags"	%>
 <div class="row">
    <nav class="navbar navbar-inverse   navbar-static-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#ts-top-menu">
                    <span class="sr-only">
                        Navigation buttons
                    </span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>             
            </div>                   
            <div class="navbar-collapse collapse" id="ts-top-menu">
                <ul class="nav navbar-nav">
                  <li><a href="<spring:url value="/Gestion"/>">Gestion </a> </li>
                  <li><a href="<spring:url value="/Stakeholder"/>">Stakeholder</a></li>
                  <li><a href="<spring:url value="/Proyecto"/>">Proyectos</a></li>
                  <li><a href="<spring:url value="/Requisito"/>">Requisitos</a></li>
                  <li><a href="<spring:url value="/RequisitoSimple"/>">RequisitosSimple</a></li>
                  <li><a href="<spring:url value="/RequisitoCompuesto"/>">RequisitosCompuesto</a></li>  
                  <li><a href="<spring:url value="/CargarDatos"/>">Datos de Prueba</a></li>        
                </ul>
            </div>
            </div>
    </nav>
 </div>
