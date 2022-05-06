<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>LISTAR.ORDEN</title>
	</head>
	<body>
			<nav class="navbar fixed-top navbar-expand-lg  navbar-light bg-light ">
       		 <div class="container-fluid">
          <a class="navbar-brand" href="#">SERVICIO TECNICO</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              	<li class="nav-item">
                	 <a class="nav-link active" aria-current="page" href="/serv-tecnico-web/ClienteController?accion=listar"> Cliente</a>
              	</li>
              	<li class="nav-item">
                	<a class="nav-link" href="/serv-tecnico-web/ClienteController?accion=form"> Crear Alumno</a>
              	</li>
              	<li class="nav-item">
                	<a class="nav-link" href="/serv-tecnico-web/OrdenController?accion=listar"> Ver Ordenes</a></a>
              	</li>
              	<li class="nav-item">
                	<a class="nav-link" href="/serv-tecnico-web/OrdenController?accion=form"> Crear Orden</a></a>
              	</li>
              </ul>
          </div>
        </div>
       </nav>
       <div class="container">
		<h1>Ordenes</h1>
		
		<table class="table">
			<thead>
				<tr>
						<th>ID</th>
						<th>Tipo de Electrodomestico</th>
						<th>Estado</th>
						<th>Fecha de Solicitud</th>					
						<th>Fecha última actualización</th>		
						<th>Descripcion Problema</th>				
				</tr>
			</thead>
			<tbody>
			<c:forEach var="orden" items="${ordenes}">
				<tr>
					<td><c:out value="${orden.id}" /></td>
					<td><c:out value="${orden.tipoElectrodomestico}" /></td>
					<td><c:out value="${orden.estado}"/></td>
					<td><c:out value="${orden.fechaSolicitud}" /></td>
					<td><c:out value="${orden.fechaUltimaActualizacion}"/></td>
					<td><c:out value="${orden.descripcionProblema}" /></td>
					<td>
						<a href="${pageContext.request.contextPath}/OrdenController?accion=editar&amp;id=${orden.id}">Editar</a> <%-- contextPath en este caso es /cft-web --%>
						<a href="${pageContext.request.contextPath}/OrdenController?accion=eliminar&amp;id=${orden.id}">Eliminar</a> <%-- contextPath en este caso es /cft-web --%>
					</td>
				</tr>
			</c:forEach>			
			</tbody>
		</table>
		</div>
	</body>
</html>