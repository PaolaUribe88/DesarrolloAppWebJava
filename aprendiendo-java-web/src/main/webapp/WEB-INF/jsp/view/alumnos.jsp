<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Alumnos</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	
</head>
<body background="blue-light">
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-5">
	<div class="container">
		<h1 class="navbar-brand">Alumnos</h1>
	</div>
	</nav>
	<div class="container">
	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>NOMBRE</td>
				<td>RUT</td>
				<td>DIRECCIÓN</td>
				<td>COMUNA</td>
			
			</tr>
		</thead>
	
	<tbody>
	<c:forEach items="${alumnos}" var="alumno">
		<tr>
			<td>${alumno.id}</td>
			<td>${alumno.nombre}</td>
			<td>${alumno.rut}</td>
			<td>${alumno.direccion}</td>
			<td>${alumno.comuna}</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>