<!-- DIRECTIVAS -->
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- FIN DIRECTIVAS -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Internalización (i18n) Bundle</h2>
	Pasos:
	<ol>
	<li> Crear archivo messages.properties dentro de la carpeta scr/main/java</li>
	<li> Crear archivo messages_en.properties dentro de la carpeta scr/main/java</li>
	</ol>
	<fmt:setLocale value="en"/><br>
	<%-- messages el nombre del archivo de extension--%>
	<fmt:setBundle basename="messages"/>
	<fmt:message key="label.saludo"/><br>
	<fmt:message key="label.stock">
		<fmt:param>50</fmt:param>
		</fmt:message>
	
	<h2>Formatear de Fechas</h2>
	<c:set var="ahora" value="<%=new java.util.Date() %>" /><%-- JSTL c:set y la <%= %> es una expression de JSP --%>
	<fmt:formatDate value="${ahora}" pattern="yyyy-MM-dd"/><br />
	<fmt:formatDate value="${ahora}" type="date" /><br />
	<fmt:formatDate value="${ahora}" type="time" /><br />
	<fmt:formatDate value="${ahora}" type="both" />
	
	<h2>Import</h2>
	<textarea rows="10" cols="20">
	<%--<c:import url="https://mindicador.cl/api"--%>
	</textarea>


	<H2>Bucle forEach</H2>
	<ul>
	<c:forEach items="${paramValues}" var="parametro">
	<li>${parametro.key}</li>
	</c:forEach>
	</ul>


	<h2>Bucle forTokens</h2>
	<ul>
	<c:forTokens items="uno,dos,tres,cuatro" delims="," var="numero">
	<li>${numero}</li>
	</c:forTokens></ul>
	
	<h2>Condiciones</h2>
	
	<c:if test="${param.activo =='true'}">
	<p>El Usuario esta activo</p>
	</c:if>
	

	<h2>Output</h2>
	<!-- OUTPUT devuelve datos ingresador en la url-param objeto implicito que recupera los datos en la url -->
	<c:out value="${param.nombre}" default="Sin Nombre"/>
	<!-- ASI SE PREVIENE ATAQUES XSS -->
	

   <h2>Generar URL</h2>
	<c:url value="/aprendiendo-java-web/index.jsp">
	<c:param name="nombre" value="Paola" />
	</c:url>
</body>
</html>