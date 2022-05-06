<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>FORM.CLIENTE</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
        <div class="container-fluid">
        <h1>Cliente</h1>
         <form method="POST" action="/serv-tecnico-web/OrdenController">
			<input type="hidden" name="id" value="${orden.id}" />
			<div class="mb-3">
	  			<label for="nombre" class="form-label">Nombre:</label>
	  			<input type="text" class="form-control" value="${cliente.nombre}" id="nombre" name="nombre" />
			</div>
			<div class="mb-3">
	  			<label for="estado" class="form-label">Estado:</label>
	  			<input type="text" class="form-control" value="${orden.estado}" id="estado" name="estado" />
			</div>
			<div class="mb-3">
	  			<label for="fechaSolicitud" class="form-label">Telefono:</label>
	  			<input type="text" class="form-control" value="${cliente.telefono}" id="telefono" name="telefono" />
			</div>
			<div class="mb-3">
	  			<label for="direccion" class="form-label">Direccion:</label>
	  			<input type="text" class="form-control" value="${cliente.direccion}" id="direccion" name="direccion" />
			</div>
				
			<button class="btn btn-primary" type="submit">Guardar</button>
		</form>
		</div>	
		
	<body>
</html>