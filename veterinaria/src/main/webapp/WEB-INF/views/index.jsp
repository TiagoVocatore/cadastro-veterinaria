<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Arca de Noé</title>
<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
	<link href='<spring:url value="/resources/css/estilo.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/jquery-3.5.1.min.js" />'></script>
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
</head>
<body>
<div class="container">
<div class="row">

<div class="col-lg-12 mt-2"> 
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
</div>

<div class="col-lg-3 mt-2">
	<jsp:include page="/WEB-INF/views/menuLateral.jsp"></jsp:include>
 </div>
 
 <div class="col-lg-9 mt-2">
				
	<div id="carouselExampleIndicators" class="carousel slide"
		 data-ride="carousel">
	<ol class="carousel-indicators">
	<li data-target="#carouselExampleIndicators" data-slide-to="0"
		class="active"></li>
	<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	</ol>
	<div class="carousel-inner" role="listbox">
	<div class="carousel-item active">
	<img class="d-block img-fluid" src="/resources/imagens/cachorro.jpeg"
								alt="First slide">
    </div>
    <div class="carousel-item">
	<img class="d-block img-fluid" src="/resources/imagens/gato.jpg"
								alt="Second slide">
	</div>
	<div class="carousel-item">
	<img class="d-block img-fluid" src="/resources/imagens/coelho.jpg"
								alt="Second slide">
	</div>					
	</div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
	</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
	</a>
	</div>
	
 </div>
</div>
</div>

<jsp:include page="/WEB-INF/views/rodape.jsp"></jsp:include>

</body>
</html>