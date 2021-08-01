<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar exame</title>
<link href='<spring:url value="/resources/css/bootstrap.css" />'
	rel="stylesheet" />
<link href='<spring:url value="/resources/css/estilo.css" />'
	rel="stylesheet" />
<script src='<spring:url value="/resources/js/jquery-3.5.1.min.js" />'></script>
<script src='<spring:url value="/resources/js/bootstrap.js" />'></script>
<spring:url value="/exame/deleta/" var="deleta"></spring:url>
<spring:url value="/exame/altera/" var="altera"></spring:url>
<spring:url value="/exame/salva/" var="salva"></spring:url>
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
	    	   
		<div class="col-lg-5 mt-2">
		
		<h3 class="bg-light"> Cadastro de exame </h3>
			 <form:form action="${salva}" modelAttribute="exame"
			 enctype="multipart/form-data" class="bg-light" id="form">

					<form:hidden path="codigo" />
					
					<div class="form-group col-lg-12">
					<label>Tipo</label>
					<form:input path="nome" value="${exame.nome}" cssClass="form-control" />
					</div>

					<input type="submit" class="btn btn-primary" name="salva"
					value="salvar" /> <br><br>

			</form:form>
			</div>

			   
			<div class="col-lg-7 mt-2">
				<c:if test="${not empty exames }">
				<h3 class="bg-light"> Tabela de exames</h3>
				<table class="table table-dark">
				<thead>
				<tr>
								<th scope="col">Código</th>
								<th scope="col">Nome</th>
					
				</tr>
				</thead>
				<tbody>
				<c:forEach var="exame" items="${exames}">
				<tr>
							   <td scope="row">${exame.codigo}</td>
							   <td>${exame.nome}</td>
							   <td><a href="${altera}${exame.codigo}"
							   class="btn btn-warning">Alterar</a></td>
							   <td><a href="${deleta}${exame.codigo}"
							   class="btn btn-danger"
							   onclick="return confirm('Deseja deletar esse exame?');">Deletar</a></td>
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