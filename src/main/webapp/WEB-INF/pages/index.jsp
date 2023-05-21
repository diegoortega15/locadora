<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>LoCar</title>

<spring:url value="/resources/vendor/fontawesome-free/css/all.min.css" var="allmincss" />
<link href="${allmincss}" rel="stylesheet" />

<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<spring:url value="/resources/css/sb-admin-2.min.css" var="sbadmin2mincss" />
<link href="${sbadmin2mincss}" rel="stylesheet" />

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script src="https://accounts.google.com/gsi/client" async defer></script>

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-10 col-lg-12 col-md-9">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row">
							<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">LoCar</h1>
									</div>
									
									<c:if test="${sucesso == false}">
											<div class="alert alert-danger alert-dismissible fade show" role="alert">
											  <strong>Erro!</strong> Login ou senha inválidos.
											  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
											    <span aria-hidden="true">&times;</span>
											  </button>
											</div>
										</c:if>
										
										
									<form:form class="user" id="login-form" action="login" method="post">
									
										<input type="hidden" id="credential" name="credential">
										
										<div class="form-group">
											<input type="text" class="form-control form-control-user" id="exampleInputEmail" name="login"
												aria-describedby="emailHelp" placeholder="Login" required="required">
										</div>
										<div class="form-group">
											<input type="password" class="form-control form-control-user" id="exampleInputPassword" name="senha"
												placeholder="Senha" required="required">
										</div>
										
										<button class="btn btn-primary btn-user btn-block" type="submit" id="entrar" name="entrar">Entrar</button>
										 
										
										<hr>
										
										<!-- LOGIN COM O GOOGLE -->
										<div align="center">
								           <div id="g_id_onload"
								                data-client_id="938526970055-ghccnb65mffa8a0im2eedqguipff43fb.apps.googleusercontent.com"
								                data-context="signin"
								                data-ux_mode="popup"
								                data-login_uri="http://localhost:8080/locadora/"
								                data-auto_prompt="false"
								                data-callback="onSignIn">
								           </div>
								
								           <div class="g_id_signin"
								                data-type="standard"
								                data-shape="rectangular"
								                data-theme="outline"
								                data-text="signin_with."
								                data-size="large"
								                data-locale="pt-BR"
								                data-logo_alignment="left">
								           </div>
										</div> 
										
									</form:form>
									
									<hr>
									
									<div class="text-center">
										<a class="small" href="/locadora/cliente/cadastrar">Criar uma Conta!</a>
									</div>
								</div>
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
	
	<script>
		//google callback. This function will redirect to our login servlet
		function onSignIn(googleUser) {
			console.log("GOOGLE CREDENTIAL OBJECT");
            console.log(googleUser.credential);

            $("#credential").val(googleUser.credential);
            $("#login-form").submit();
		}
	</script>
	
</body>

</html>