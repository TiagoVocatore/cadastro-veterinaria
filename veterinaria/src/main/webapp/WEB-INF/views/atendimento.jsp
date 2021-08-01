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
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
<spring:url value="/atendimento/deleta/" var="deleta"></spring:url>
<spring:url value="/atendimento/altera/" var="altera"></spring:url>
<spring:url value="/atendimento/salva/" var="salva"></spring:url>
<spring:url value="/atendimento/emergencia/" var="emergencia"></spring:url>
</head>
<body>
	<div class="container">
	<div class="row">

			<div class="col-lg-12 mt-2">
		
			<c:if test="${not empty mensagemErro }">
			<div id="divMensagemErro" class="alert alert-danger" role="alert">
			${mensagemErro }</div>
			</c:if>

			<c:if test="${not empty mensagemSucesso }">
			<div id="divMensagemSucesso" class="alert alert-success"
			role="alert">${mensagemSucesso }</div>
	    	</c:if>
		
			</div>

			<div class="col-lg-12 mt-2">
			<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
			</div>

			<div class="col-lg-4 mt-2">
			<div class="list-group">
	        <a href="#" class="list-group-item">Cadastrar agendamento 
	        <div style="display: none">
			
			<form:form action="${salva}" modelAttribute="atendimento"
			enctype="multipart/form-data" class="bg-light" id="form">

			<form:hidden path="codigo" />

			<div class="form-group col-lg-12">
			<label>Selecione um animal: </label> <br>
			<c:forEach var="animal" items="${animais}">
		    <input type="checkbox" value="${animal.codigo }" 
		    name="animal"> ${animal.nome } <br>
			</c:forEach>
			</div>

			<div class="form-group col-lg-12">
			<label>Atendimento: agendamento </label> <br>
			<form:hidden path="tipoAtendimento" value="1" />
			</div>
			
			<div class="form-group col-lg-12">
			<label>Selecione a data: </label> <br>
			<form:input type="date" path="data" value="${atendimento.data}"
			cssClass="form-control" />
		    </div>

			<div class="form-group col-lg-12">
			<label>Selecione a hora da consulta: </label> <br>
			<form:input type="time" path="hora" value="${atendimento.hora}"
			cssClass="form-control" />
			</div>


			<div class="form-group col-lg-12">
			<label>Escolha um veterinário: </label> <br>
			<c:forEach var="veterinario" items="${veterinarios}">
			<c:if test="${veterinario.disponibilidade.nome ne 'plantao' 
			 }" >
			<input type="checkbox" value="${veterinario.codigo }"
			name="veterinario"> ${veterinario.nome }  <br>
			</c:if>
			</c:forEach>
			</div>

			<input type="submit" class="btn btn-primary" name="salva"
			value="salvar" /> <br><br>

			</form:form>

			</div> </a>
			
		    <a href="#" class="list-group-item">Cadastrar emergência 
		    <div style="display: none">
			
			<form:form action="${salva}" modelAttribute="atendimento"
			enctype="multipart/form-data" class="bg-light" id="form">

			<form:hidden path="codigo" />

			<div class="form-group col-lg-12">
			<label>Selecione um animal: </label> <br>
			<c:forEach var="animal" items="${animais}">
		    <input type="checkbox" value="${animal.codigo }" 
		    name="animal"> ${animal.nome } <br>
			</c:forEach>
			</div>

			<div class="form-group col-lg-12">
			<label>Atendimento: emergência </label> <br>
			<form:hidden path="tipoAtendimento" value="2" />
			</div>
			
			<div class="form-group col-lg-12">
			<label>Selecione a data: </label> <br>
			<form:input type="date" path="data" value="${atendimento.data}"
			cssClass="form-control" />
		    </div>

			<div class="form-group col-lg-12">
			<label>Selecione a hora da consulta: </label> <br>
			<form:input type="time" path="hora" value="${atendimento.hora}"
			cssClass="form-control" />
			</div>


			<div class="form-group col-lg-12">
			<label>Selecione um veterinário do plantão: </label> <br>
			<c:forEach var="veterinario" items="${veterinarios}">
			<c:if test="${veterinario.disponibilidade.nome ne 'total'}" >
			<input type="checkbox" value="${veterinario.codigo }"
			name="veterinario"> ${veterinario.nome }  <br>
			</c:if>
			</c:forEach>
			</div>

			<input type="submit" class="btn btn-primary" name="salva"
			value="salvar" /> <br><br>

			</form:form>

			</div> </a> 
			</div>
			</div>

			<div class="col-lg-4 mt-2"> 
			<div class="content"></div>
			</div>
			
			<div class="col-lg-12 mt-2">
				<c:if test="${not empty atendimentos }">
				<h3 class="bg-light"> Tabela de atendimentos </h3>
				<table class="table table-dark">
				<thead>
				<tr>
								<th scope="col">Código</th>
								<th scope="col">Nome do animal</th>
								<th scope="col">Data</th>
								<th scope="col">Hora</th>
								<th scope="col">Tipo</th>
								<th scope="col">Verinario</th>
								<th scope="col">Deletar</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="atendimento" items="${atendimentos}">
				<tr>
							   <th scope="row">${atendimento.codigo}</tH>
							   <td>${atendimento.animal.nome}</td>
							   <td>${atendimento.data}</td>
							   <td>${atendimento.hora}</td>
							   <td>${atendimento.tipoAtendimento.tipo}</td>
							   <td>${atendimento.veterinario.nome}</td>
							   <td><a href="${deleta}${atendimento.codigo}"
							   class="btn btn-danger"
							   onclick="return confirm('Deseja deletar esse atendimento?');">Deletar</a></td>
							   
							 
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


<script type="text/javascript">
$('a.list-group-item').click(function(event) {
	  event.preventDefault();
	  $('div.content').html($('div', this).html());
	});
</script>


</body>
</html>