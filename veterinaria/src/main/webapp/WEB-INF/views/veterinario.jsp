<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de veterinario</title>
<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<link href='<spring:url value="/resources/css/estilo.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/jquery-3.5.1.min.js" />'></script>
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
<spring:url value="/veterinario/deleta/" var="deleta"></spring:url>
<spring:url value="/veterinario/altera/" var="altera"></spring:url>
<spring:url value="/veterinario/salva/" var="salva"></spring:url>
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
	    	   
		<div class="col-lg-6 mt-2">
		
		<h3 class="bg-light"> Cadastro de veterinário </h3>
			 <form:form action="${salva}" modelAttribute="veterinario"
			 enctype="multipart/form-data" class="bg-light" id="form">

					<form:hidden path="codigo" />
					
					<div class="form-group col-lg-12">
					<label>Nome</label>
					<form:input path="nome" value="${veterinario.nome}" cssClass="form-control" />
					</div>

					<div class="form-group col-lg-12">
					<label>Endereço</label>
					<form:input path="endereco" value="${veterinario.endereco}" cssClass="form-control" />
					</div>


					<div class="form-group col-lg-12">
					<label>CRMV</label>
					<form:input path="crmv" value="${veterinario.crmv}" cssClass="form-control" />
					</div>
					
					<div class="form-group col-lg-12">
					<label>Selecione uma ou mais especializações: </label>
					<br>
					<c:forEach var="especie" items="${especies}">
  					<input type = "checkbox" value= "${especie.codigo }" 
  						   name = "especies"> ${especie.nome } <br>
					</c:forEach>
					<a href="/especie"> Não achou? Cadastrar espécie</a>
					</div>
					
					<div class="form-group col-lg-12">
					<label>Selecione a disponibilidade: </label>
					<br>
					<c:forEach var="disponibilidade" items="${disponibilidades}">
  					<input type = "checkbox" value= "${disponibilidade.codigo }" 
  						   name = "disponibilidade"> ${disponibilidade.nome }  <br>
					</c:forEach>
					<a href="/especie"> Não achou? Cadastrar disponibilidade</a>
					</div>
		
					<input type="submit" class="btn btn-primary" name="salva"
					value="salvar" />

			</form:form>
			</div>

			   
			<div class="col-lg-12 mt-2">
				<c:if test="${not empty veterinarios }">
				<h3 class="bg-light"> Tabela de veterinários </h3>
				<table class="table table-dark">
				<thead>
				<tr>
								<th scope="col">Código</th>
								<th scope="col">Nome</th>
								<th scope="col">Endereço</th>
								<th scope="col">Crmv</th>
								<th scope="col">Especializações</th>
								<th scope="col">Disponibilidade</th>
								<th scope="col" colspan="2">Ações</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="veterinario" items="${veterinarios}">
				<tr>
							   <td scope="row">${veterinario.codigo}</td>
							   <td>${veterinario.nome}</td>
							   <td>${veterinario.endereco}</td>
							   <td>${veterinario.crmv}</td>
							   <td>${veterinario.especies}</td>
							   <td>${veterinario.disponibilidade.nome}</td>
							   <td><a href="${altera}${veterinario.codigo}"
							   class="btn btn-warning">Alterar</a></td>
							   <td><a href="${deleta}${veterinario.codigo}"
							   class="btn btn-danger"
							   onclick="return confirm('Deseja deletar esse veterinario?');">Deletar</a></td>
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