<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-car"></i>
				</div>
				<div class="sidebar-brand-text mx-3"> LoCar </div>
			</a>

			<c:if test="${usuarioLogado.perfil.funcionalidade.painel}">
				<!-- Divider -->
				<hr class="sidebar-divider my-0">
	
				<!-- Nav Item - Dashboard -->
				<li class="nav-item active">
					<a class="nav-link" href="/locadora/painel"> 
						<i class="fas fa-angle-double-right"></i> <span>Painel</span>
					</a>
				</li>
			</c:if>
			
			<c:if test="${usuarioLogado.perfil.funcionalidade.grupoOperacao}">
				
				<!-- Divider -->
				<hr class="sidebar-divider">
	
				<!-- Heading -->
				<div class="sidebar-heading">Opera��o</div>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.locacao}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/locacao/listar-carros">
							<i class="fas fa-angle-double-right"></i> <span>Loca��o</span>
						</a>
					</li>
				</c:if>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.locacoesRealizadas}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/locacao/listar">
							<i class="fas fa-angle-double-right"></i> <span>Loca��es Realizadas</span>
						</a>
					</li>
				</c:if>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.minhasLocacoes}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/locacao/minhas-locacoes">
							<i class="fas fa-angle-double-right"></i> <span>Minhas Loca��es</span>
						</a>
					</li>
				</c:if>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.finalizarLocacao}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/locacao/listar-ativo">
							<i class="fas fa-angle-double-right"></i> <span>Finalizar Loca��o</span>
						</a>
					</li>
				</c:if>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.relatorio}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/relatorio/formulario">
							<i class="fas fa-angle-double-right"></i> <span>Relat�rio</span>
						</a>
					</li>
				</c:if>
				
			</c:if>
			
			<c:if test="${usuarioLogado.perfil.funcionalidade.grupoCadastros}">
				
				<!-- Divider -->
				<hr class="sidebar-divider">
	
				<!-- Heading -->
				<div class="sidebar-heading">Cadastros</div>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.itemAdcional}">
					<!-- Nav Item - Pages Collapse Menu -->
					<li class="nav-item">
						<a class="nav-link" href="/locadora/item-adicional/listar">
							<i class="fas fa-angle-double-right"></i> <span>Item Adicional</span>
						</a>
					</li>
				</c:if>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.localRetirada}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/local-retirada/listar">
							<i class="fas fa-angle-double-right"></i> <span>Local de Retirada</span>
						</a>
					</li>
				</c:if>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.marca}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/marca/listar">
							<i class="fas fa-angle-double-right"></i> <span>Marca</span>
						</a>
					</li>
				</c:if>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.modelo}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/modelo/listar">
							<i class="fas fa-angle-double-right"></i> <span>Modelo</span>
						</a>
					</li>
				</c:if>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.carro}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/carro/listar">
							<i class="fas fa-angle-double-right"></i> <span>Carro</span>
						</a>
					</li>
				</c:if>

			</c:if>

			<c:if test="${usuarioLogado.perfil.funcionalidade.grupoControleAcesso}">
				
				<!-- Divider -->
				<hr class="sidebar-divider">
	
				<!-- Heading -->
				<div class="sidebar-heading">Controle de Acesso</div>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.cliente}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/cliente/listar">
							<i class="fas fa-angle-double-right"></i> <span>Cliente</span>
						</a>
					</li>
				</c:if>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.funcionario}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/funcionario/listar">
							<i class="fas fa-angle-double-right"></i> <span>Funcion�rio</span>
						</a>
					</li>
				</c:if>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.perfil}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/perfil/listar">
							<i class="fas fa-angle-double-right"></i> <span>Perfil</span>
						</a>
					</li>
				</c:if>
				
			</c:if>

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">
			
			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow">
							<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" 
								data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
								<span class="mr-2 d-none d-lg-inline text-gray-600 small">${usuarioLogado.nome}</span> 
							</a> <!-- Dropdown - User Information -->
							<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#"> 
									<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Meus Dados
								</a> 
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="/locadora/sair" > 
									<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Sair
								</a>
							</div>
						</li>
					</ul>
				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Seja bem-vindo!</h1>
					</div>

					<!-- Content Row -->
					<div class="row">

						<!-- Earnings (Monthly) Card Example -->
<!-- 						<div class="col-xl-3 col-md-6 mb-4"> -->
<!-- 							<div class="card border-left-primary shadow h-100 py-2"> -->
<!-- 								<div class="card-body"> -->
<!-- 									<div class="row no-gutters align-items-center"> -->
<!-- 										<div class="col mr-2"> -->
<!-- 											<div -->
<!-- 												class="text-xs font-weight-bold text-primary text-uppercase mb-1"> -->
<!-- 												Earnings (Monthly)</div> -->
<!-- 											<div class="h5 mb-0 font-weight-bold text-gray-800">$40,000</div> -->
<!-- 										</div> -->
<!-- 										<div class="col-auto"> -->
<!-- 											<i class="fas fa-calendar fa-2x text-gray-300"></i> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->

						<!-- Earnings (Monthly) Card Example -->
<!-- 						<div class="col-xl-3 col-md-6 mb-4"> -->
<!-- 							<div class="card border-left-success shadow h-100 py-2"> -->
<!-- 								<div class="card-body"> -->
<!-- 									<div class="row no-gutters align-items-center"> -->
<!-- 										<div class="col mr-2"> -->
<!-- 											<div -->
<!-- 												class="text-xs font-weight-bold text-success text-uppercase mb-1"> -->
<!-- 												Earnings (Annual)</div> -->
<!-- 											<div class="h5 mb-0 font-weight-bold text-gray-800">$215,000</div> -->
<!-- 										</div> -->
<!-- 										<div class="col-auto"> -->
<!-- 											<i class="fas fa-dollar-sign fa-2x text-gray-300"></i> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->

						<!-- Earnings (Monthly) Card Example -->
<!-- 						<div class="col-xl-3 col-md-6 mb-4"> -->
<!-- 							<div class="card border-left-info shadow h-100 py-2"> -->
<!-- 								<div class="card-body"> -->
<!-- 									<div class="row no-gutters align-items-center"> -->
<!-- 										<div class="col mr-2"> -->
<!-- 											<div -->
<!-- 												class="text-xs font-weight-bold text-info text-uppercase mb-1">Tasks -->
<!-- 											</div> -->
<!-- 											<div class="row no-gutters align-items-center"> -->
<!-- 												<div class="col-auto"> -->
<!-- 													<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">50%</div> -->
<!-- 												</div> -->
<!-- 												<div class="col"> -->
<!-- 													<div class="progress progress-sm mr-2"> -->
<!-- 														<div class="progress-bar bg-info" role="progressbar" -->
<!-- 															style="width: 50%" aria-valuenow="50" aria-valuemin="0" -->
<!-- 															aria-valuemax="100"></div> -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 										<div class="col-auto"> -->
<!-- 											<i class="fas fa-clipboard-list fa-2x text-gray-300"></i> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->

						<!-- Pending Requests Card Example -->
<!-- 						<div class="col-xl-3 col-md-6 mb-4"> -->
<!-- 							<div class="card border-left-warning shadow h-100 py-2"> -->
<!-- 								<div class="card-body"> -->
<!-- 									<div class="row no-gutters align-items-center"> -->
<!-- 										<div class="col mr-2"> -->
<!-- 											<div -->
<!-- 												class="text-xs font-weight-bold text-warning text-uppercase mb-1"> -->
<!-- 												Pending Requests</div> -->
<!-- 											<div class="h5 mb-0 font-weight-bold text-gray-800">18</div> -->
<!-- 										</div> -->
<!-- 										<div class="col-auto"> -->
<!-- 											<i class="fas fa-comments fa-2x text-gray-300"></i> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2021</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">�</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
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

	<!-- Page level plugins -->
	<script type="text/javascript" src="<c:url value="/resources/vendor/chart.js/Chart.min.js" />"> </script>
	
	<!-- Page level custom scripts -->
	<script type="text/javascript" src="<c:url value="/resources/js/demo/chart-area-demo.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/demo/chart-pie-demo.js" />"> </script>
	
</body>

</html>