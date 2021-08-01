<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de animal</title>
<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<link href='<spring:url value="/resources/css/estilo.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/jquery-3.5.1.min.js" />'></script>
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
<spring:url value="/animal/deleta/" var="deleta"></spring:url>
<spring:url value="/animal/altera/" var="altera"></spring:url>
<spring:url value="/animal/salva/" var="salva"></spring:url>
</head>
<body>
	<div class="container">
	<div class="row">
	
	<div class="col-lg-12 mt-2">
				<c:if test="${not empty mensagemErro }">
					<div id="divMensagemErro" class="alert alert-danger" role="alert">
						${mensagemErro }
					</div>
				</c:if>
				
				<c:if test="${not empty mensagemSucesso }">
					<div id="divMensagemSucesso" class="alert alert-success" role="alert">
						${mensagemSucesso }
					</div>
				</c:if>
	</div>			

	<div class="col-lg-12 mt-2">
		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	    </div>
	    
		<div class="col-lg-4 mt-2">
		<h3 class="bg-light"> Cadastro de animal </h3>
			 <form:form action="${salva}" modelAttribute="animal"
			 enctype="multipart/form-data" class="bg-light" id="form">

					<form:hidden path="codigo" />
					
					<div class="form-group col-lg-12">
					<label>Nome</label>
					<form:input path="nome" value="${animal.nome}" cssClass="form-control" />
					</div>

					<div class="form-group col-lg-12">
					<label>Selecione uma espécie: </label>
					<br>
					<c:forEach var="especie" items="${especies}">
  					<input type = "checkbox" value= "${especie.codigo }" 
  						   name = "especie"> ${especie.nome } <br>
					</c:forEach>
					<a href="/especie"> Não achou? cadastrar espécie</a>
					</div>


					<div class="form-group col-lg-12">
					<label>Raça</label>
					<form:input path="raca" value="${animal.raca}" cssClass="form-control" />
					</div>

					<div class="form-group col-lg-12">
					<label>Idade</label>
					<form:input path="idade" value="${animal.idade}" cssClass="form-control" />
					</div>

					<div class="form-group col-lg-12">
					<label>Selecione um cliente: </label>
					<br>
					<c:forEach var="cliente" items="${clientes}">
  					<input type = "checkbox" value= "${cliente.codigo }" 
  						   name = "cliente"> ${cliente.nome } <br>
					</c:forEach>
					<a href="/cliente"> Não achou? cadastrar cliente</a>
					</div>
		
					<input type="submit" class="btn btn-primary" name="salva"
					value="salvar" /> <br><br>

			</form:form>
			</div>

			<div class="col-lg-8 mt-2">
				<c:if test="${not empty animais }">
				<h3 class="bg-light"> Tabela de animais </h3>
				<table class="table table-dark">
				<thead>
				<tr>
								<th scope="col">Código</th>
								<th scope="col">Nome</th>
								<th scope="col">Espécie</th>
								<th scope="col">Raça</th>
								<th scope="col">Idade</th>
								<th scope="col">Dono</th>
								<th scope="col" colspan="2">Ações</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="animal" items="${animais}">
				<tr>
							   <th scope="row">${animal.codigo}</tH>
							   <td>${animal.nome}</td>
							   <td>${animal.especie.nome}</td>
							   <td>${animal.raca}</td>
							   <td>${animal.idade}</td>
							    <td>${animal.cliente.nome}</td>
							   <td><a href="${altera}${animal.codigo}"
							   class="btn btn-warning">Alterar</a></td>
							   <td><a href="${deleta}${animal.codigo}"
							   class="btn btn-danger"
							   onclick="return confirm('Deseja deletar esse animal?');">Deletar</a></td>
			   </tr>
			   </c:forEach>
			   </tbody>
			   </table>
			   </c:if>
			   </div>

</div>
</div>

<script type="text/javascript">
		$(document).ready(function() {
			$('#divMensagemErro').delay(5000).fadeOut('slow');
			$('#divMensagemSucesso').delay(5000).fadeOut('slow');
		});
	</script>
	
</body>
</html>