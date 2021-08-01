<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script src='<spring:url value="/resources/js/jquery.mask.min.js" />'></script>
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
<spring:url value="/cliente/deleta/" var="deleta"></spring:url>
<spring:url value="/cliente/altera/" var="altera"></spring:url>
<spring:url value="/cliente/salva/" var="salva"></spring:url>
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
			<h3 class="bg-light"> Cadastro de cliente </h3>
				<form:form action="${salva}" modelAttribute="cliente"
					enctype="multipart/form-data" class="bg-light" id="form">

					<form:hidden path="codigo" />

					<div class="form-group col-lg-12">
						<label>Nome</label>
						<form:input path="nome" value="${cliente.nome}" cssClass="form-control" />
					</div>

					<div class="form-group col-lg-12">
						<label>CPF</label>
						<form:input path="cpf" id="cpf" name="cpf" value="${cliente.cpf}" cssClass="form-control" />
					</div>


					<div class="form-group col-lg-12">
						<label>Endereco</label>
						<form:input path="endereco" value="${cliente.endereco}" cssClass="form-control" />
					</div>

					<div class="form-group col-lg-12">
						<label>Telefone</label>
						<form:input path="telefone" name="telefone" id="telefone" value="${cliente.telefone}" cssClass="form-control" />
					</div>

					<input type="submit" class="btn btn-primary" name="salva"
						value="salvar" /> <br><br>
				</form:form>
			</div>

<div class="col-lg-8 mt-2 ">
				<c:if test="${not empty clientes }">
				<h3 class="bg-light"> Tabela de clientes </h3>
				<div class="table-responsive">
				<table class="table table-dark">
				<thead>
				<tr>
								<th scope="col">Código</th>
								<th scope="col">Nome</th>
								<th scope="col">CPF</th>
								<th scope="col">Endereco</th>
								<th scope="col">Telefone</th>
								<th scope="col" colspan="2">Ações</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="cliente" items="${clientes}">
				<tr>
							   <td scope="row">${cliente.codigo}</td>
							   <td>${cliente.nome}</td>
							   <td>${cliente.cpf}</td>
							   <td>${cliente.endereco}</td>
							   <td>${cliente.telefone}</td>
							   <td><a href="${altera}${cliente.codigo}"
							   class="btn btn-warning"> Alterar</a></td>
							   <td><a href="${deleta}${cliente.codigo}"
							   class="btn btn-danger"
							   onclick="return confirm('Deseja deletar esse cliente?');">Deletar</a></td>
			   </tr>
			   </c:forEach>
			   </tbody>
			   </table>
			   </div>
			   </c:if>
			   </div>

	</div>
	</div>

    <script type="text/javascript">
    $("#cpf").mask(" 000.000.000-00");
    </script>
    
    <script type="text/javascript">
    $("#telefone").mask("(00)00000-0000");
    </script>
    
    <script type="text/javascript">
		$(document).ready(function() {
			$('#divMensagemErro').delay(5000).fadeOut('slow');
			$('#divMensagemSucesso').delay(5000).fadeOut('slow');
		});
	</script>

</body>
</html>