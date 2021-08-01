<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de prontuario</title>
<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<link href='<spring:url value="/resources/css/estilo.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/jquery-3.5.1.min.js" />'></script>
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
<spring:url value="/prontuario/deleta/" var="deleta"></spring:url>
<spring:url value="/prontuario/altera/" var="altera"></spring:url>
<spring:url value="/prontuario/salva/" var="salva"></spring:url>
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
		
		<h3 class="bg-light"> Cadastro de prontuario </h3>
			 <form:form action="${salva}" modelAttribute="prontuario"
			 enctype="multipart/form-data" class="bg-light" id="form">

					<form:hidden path="codigo" />
					
					<div class="form-group col-lg-12">
					<label>Selecione um atendimento: </label>
					<br>
					<c:forEach var="atendimento" items="${atendimentos}">
  					<input type = "checkbox" value= "${atendimento.codigo }" 
  						   name = "atendimento"> ${atendimento.animal.nome } -  
  						   ${atendimento.data } -  ${atendimento.hora }<br>
					</c:forEach>
					<a href="/atendimento"> Não achou? Cadastrar atendimento</a>
					</div>
					
					<div class="form-group col-lg-12">
					<label>Selecione uma ou mais exames: </label>
					<br>
					<c:forEach var="exame" items="${exames}">
  					<input type = "checkbox" value= "${exame.codigo }" 
  						   name = "exames"> ${exame.nome } <br>
					</c:forEach>
					<a href="/exames"> Não achou? Cadastrar exame</a>
					</div>
					
					<div class="form-group col-lg-12">
					<label>Selecione um ou mais medicamentos: </label>
					<br>
					<c:forEach var="medicamento" items="${medicamentos}">
  					<input type = "checkbox" value= "${medicamento.codigo }" 
  						   name = "medicamentos"> ${medicamento.nome } <br>
					</c:forEach>
					<a href="/medicamentos"> Não achou? Cadastrar medicamento</a>
					</div>
					
					<div class="form-group col-lg-12">
					<label>Diagnóstico:</label>
					<form:input path="diagnostico" value="${prontuario.diagnostico}" cssClass="form-control" />
					</div>
					
					<div class="form-group col-lg-12">
					<label>Prescrição do medicamento:</label> <br>
					<form:textarea path="prescricao" cssClass="form-control"></form:textarea>
					</div>
					
		
					<input type="submit" class="btn btn-primary" name="salva"
					value="salvar" /> <br><br>

			</form:form>
			</div>

			  <div class="col-lg-12 mt-2">
				<c:if test="${not empty prontuarios }">
				<h3 class="bg-light"> Tabela de prontuarios </h3>
				<table class="table table-dark">
				<thead>
				<tr>
								<th scope="col">Código</th>
								<th scope="col">Atendimento</th>
								<th scope="col">Exames</th>
								<th scope="col">Medicamentos</th>
								<th scope="col">Diagnóstico</th>
								<th scope="col">Prescrição</th>
								<th scope="col" colspan="2">Ações</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="prontuario" items="${prontuarios}">
				<tr>
							   <td scope="row">${prontuario.codigo}</td>
							   <td>${prontuario.atendimento}</td>
							   <td>${prontuario.exames}</td>
							   <td>${prontuario.medicamentos}</td>
							   <td>${prontuario.diagnostico}</td>
							   <td>${prontuario.prescricao}</td>
							   <td><a href="${altera}${prontuario.codigo}"
							   class="btn btn-warning">Alterar</a></td>
							   <td><a href="${deleta}${prontuario.codigo}"
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