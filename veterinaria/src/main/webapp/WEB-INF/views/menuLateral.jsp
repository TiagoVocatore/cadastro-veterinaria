<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>      
<spring:url value="/animal" var="animal"></spring:url>
<spring:url value="/cliente" var="cliente"></spring:url>
<spring:url value="/disponibilidade" var="disponibilidade"></spring:url>
<spring:url value="/veterinario" var="veterinario"></spring:url>
<spring:url value="/especie" var="especie"></spring:url>    
<spring:url value="/tipoAtendimento" var="tipoAtendimento"></spring:url>  
<spring:url value="/atendimento" var="atendimento"></spring:url> 
<spring:url value="/exame" var="exame"></spring:url>   
<spring:url value="/medicamento" var="medicamento"></spring:url> 
<spring:url value="/prontuario" var="prontuario"></spring:url> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
	<link href='<spring:url value="/resources/css/estilo.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/jquery-3.5.1.min.js" />'></script>
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
</head>
<body>

<div class="list-group">
	    <a href="${especie }" class="list-group-item">Cadastrar espécie</a>
		<a href="${cliente }" class="list-group-item">Cadastrar cliente</a>
		<a href="${animal }" class="list-group-item">Cadastrar animal</a>
		<a href="${disponibilidade }" class="list-group-item">Cadastrar disponibilidade</a>
		<a href="${veterinario }" class="list-group-item">Cadastrar veterinário</a>
		<a href="${tipoAtendimento }" class="list-group-item">Cadastrar tipo de atendimento</a>
		<a href="${atendimento }" class="list-group-item">Cadastrar atendimento</a>
		<a href="${exame }" class="list-group-item">Cadastrar exame</a>
		<a href="${medicamento }" class="list-group-item">Cadastrar medicamento</a>
		<a href="${prontuario }" class="list-group-item">Cadastrar prontuário</a>
	</div>

</body>
</html>