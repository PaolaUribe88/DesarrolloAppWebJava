<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>STARTECH</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body>
		<nav class="navbar fixed-top navbar-expand-lg  navbar-light bg-light ">
        <div class="container-fluid">
          <a class="navbar-brand" href="#" >SERVICIO TECNICO</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              	<li class="nav-item">
                	 <a class="nav-link active" aria-current="page" href="/serv-tecnico-web/ClienteController?accion=listar"> CLIENTE</a>
              	</li>
              	<li class="nav-item">
                	<a class="nav-link" href="/serv-tecnico-web/ClienteController?accion=form"> Crear CLIENTE</a>
              	</li>
              	<li class="nav-item">
                	<a class="nav-link" href="/serv-tecnico-web/OrdenController?accion=listar"> Ver CLIENTE</a></a>
              	</li>
              	<li class="nav-item">
                	<a class="nav-link" href="/serv-tecnico-web/OrdenController?accion=form"> Crear ORDEN</a></a>
              	</li>
              	<li class="nav-item">
                	<a class="nav-link" href="/cft-web/CarreraController?accion=form"> ver ORDEN</a></a>
              	</li>
              </ul>
          </div>
        </div>
		</nav>
	</body>
</html>