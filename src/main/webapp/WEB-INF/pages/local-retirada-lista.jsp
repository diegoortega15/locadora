<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
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

<spring:url value="/resources/vendor/datatables/dataTables.bootstrap4.min.css" var="dataTablesbootstrap4mincss" />
<link href="${dataTablesbootstrap4mincss}" rel="stylesheet" />

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
				<div class="sidebar-heading">Operação</div>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.locacao}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/locacao/listar-carros">
							<i class="fas fa-angle-double-right"></i> <span>Locação</span>
						</a>
					</li>
				</c:if>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.locacoesRealizadas}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/locacao/listar">
							<i class="fas fa-angle-double-right"></i> <span>Locações Realizadas</span>
						</a>
					</li>
				</c:if>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.minhasLocacoes}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/locacao/minhas-locacoes">
							<i class="fas fa-angle-double-right"></i> <span>Minhas Locações</span>
						</a>
					</li>
				</c:if>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.finalizarLocacao}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/locacao/listar-ativo">
							<i class="fas fa-angle-double-right"></i> <span>Finalizar Locação</span>
						</a>
					</li>
				</c:if>
				
				<c:if test="${usuarioLogado.perfil.funcionalidade.relatorio}">
					<li class="nav-item">
						<a class="nav-link" href="/locadora/relatorio/formulario">
							<i class="fas fa-angle-double-right"></i> <span>Relatório</span>
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
							<i class="fas fa-angle-double-right"></i> <span>Funcionário</span>
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
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Search -->

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
						<h1 class="h3 mb-0 text-gray-800">Local de Retirada</h1>
						
						<div>
							<a href="/locadora/local-retirada/novo" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
								<i class="fa fa-plus-circle fa-sm text-white-50"></i> Novo Local de Retirada
							</a>
							
							<a href="/locadora/local-retirada/exportar" class="d-none d-sm-inline-block btn btn-sm btn-success shadow-sm">
								<i class="fas fa-file-excel fa-sm text-white-50"></i> Exportar
							</a>
						</div>
						
					</div>
					
					<c:if test="${sucesso == true}">
						<div class="alert alert-success alert-dismissible fade show" role="alert">
							<strong>Sucesso!</strong> Operação realizada com sucesso.
							<button type="button" class="close" data-dismiss="alert" aria-label="Fechar">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:if>
						
					<div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Locais de Retiradas Cadastradas</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th width="90%">Nome</th>
                                            <th width="10%">Ações</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach var="localRetirada" items="${listLocalRetirada}">
											<tr>
												<td>${localRetirada.nome}</td>
												<td>
	                                            	<a href="editar?id=${localRetirada.id}" class="btn btn-primary btn-circle btn-sm">
				                                        <i class="fa fa-edit"></i>
				                                    </a>
				                                    
													<a href="deletar?id=${localRetirada.id}" class="btn btn-danger btn-circle btn-sm">
				                                        <i class="fas fa-trash"></i>
				                                    </a>
												</td>
											</tr>
										</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
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
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
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
    <script type="text/javascript" src="<c:url value="/resources/vendor/datatables/jquery.dataTables.min.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.min.js" />"> </script>
	
    <!-- Page level custom scripts -->
    <script type="text/javascript" src="<c:url value="/resources/js/demo/datatables-demo.js" />"> </script>
	
</body>

</html>