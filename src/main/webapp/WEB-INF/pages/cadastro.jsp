<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Register</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<spring:url value="/resources/css/sb-admin-2.min.css" var="sbadmin2mincss" />
<link href="${sbadmin2mincss}" rel="stylesheet" />

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Criando uma nova conta!</h1>
							</div>
							
							<form:form class="user" id="cadastro-form" action="salvar-externo" method="post">
								<div class="form-group">
									<input type="text" class="form-control form-control-user" id="nome" name="nome" placeholder="Nome" required="required">
								</div>
								<div class="form-group">
									<input type="email" class="form-control form-control-user" id="email" name="email" placeholder="E-mail" required="required">
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user" id="login" name="login" placeholder="Login" required="required">
									</div>
									<div class="col-sm-6">
										<input type="password" class="form-control form-control-user" id="senha" name="senha" placeholder="Senha" required="required">
									</div>
								</div>
								<hr>
<!-- 								<a href="" class="btn btn-primary btn-user btn-block">Salvar</a> -->
									<input type="submit" class="btn btn-primary btn-user btn-block" value="Salvar">
							</form:form>
							
							<hr>
							<div class="text-center">
								<a class="small" href="/locadora/">Já tem uma conta? Faça seu Login!</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Bootstrap core JavaScript-->
	<script type="text/javascript" src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"> </script>

	<!-- Core plugin JavaScript-->
	<script type="text/javascript" src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js" />"> </script>

	<!-- Custom scripts for all pages-->
	<script type="text/javascript" src="<c:url value="/resources/js/sb-admin-2.min.js" />"> </script>

</body>

</html>