<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Rectangulo</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<%@ include file="/WEB-INF/jsp/includes/cabecera.jsp" %>
<div class="container">
	<h1>Rectangulo</h1>
	<form method="GET" action="RectanguloControllerServlet">
		<div class="mb-3">
			<select name= "operacion" class="form-select">
  				<option selected>Seleccione una Opcion</option>
 				<option value="1">Calcular Area</option>
  				<option value="2">Calcular Perimetro</option>	
			</select>
		</div>
		<div class="mb-3">
			<label for="base" class = "from-label">Base</label>
			<input type="text" class= "fro-control" id="base" name="base">
		</div>
		<div class="mb-3">
			<label for="altura" class = "from-label">Altura</label>
			<input type="text" class= "fro-control" id="altura" name="altura">
		</div>
		<button class= "btn btn-primary" type="submit">Calcular</button>
	</form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</div>
</body>
</html>