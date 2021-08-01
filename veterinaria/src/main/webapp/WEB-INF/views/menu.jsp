<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <nav class="navbar navbar-expand-lg navbar-light" id="menu">
    <div class="container">
    <a class="navbar-brand" href="/"><img src="/resources/imagens/arca.png" height="150px"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
    <ul class="navbar-nav ml-auto">
    <li class="nav-item active">
    <a class="nav-link" href="/">Home
    <span class="sr-only">(current)</span>
    </a>
    </li>
    </ul>
    </div>
    </div>
    </nav>
    
</body>
</html>