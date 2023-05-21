<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
						<h1 class="h3 mb-0 text-gray-800">Locação</h1>
					</div>
					
					<div class="card shadow mb-4">
                        
                        <div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Locação: ${locacao.identificador}</h6>
                        </div>
                        
                        <div class="card-body">
                            
							<form:form action="salvar" method="post" modelAttribute="locacao">
								
								<h5>Dados do Carro</h5>
								
								<div class="form-row">
							    	<div class="form-group col-md-4">
							  			<label for="marca">Marca</label> 
										<select class="form-control" id="single-select-field" name="marca.id" required="required" disabled="disabled">
											<option value="">Selecione um marca</option>
											<c:forEach var="marcaVar" items="${marcas}">
												<c:choose>
													<c:when test="${locacao.carro.marca.id == marcaVar.id}">
														<option selected="selected" value="${marcaVar.id}">${marcaVar.nome}</option>
													</c:when>
													<c:otherwise>
														<option value="${marcaVar.id}">${marcaVar.nome}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
							  		</div>
							  		
							  		<div class="form-group col-md-4">
							  			<label for="modelo">Modelo</label> 
										<select class="form-control" id="single-select-field" name="modelo.id" required="required" disabled="disabled">
											<option value="">Selecione um modelo</option>
											<c:forEach var="modeloVar" items="${modelos}">
												<c:choose>
													<c:when test="${locacao.carro.modelo.id == modeloVar.id}">
														<option selected="selected" value="${modeloVar.id}">${modeloVar.nome}</option>
													</c:when>
													<c:otherwise>
														<option value="${modeloVar.id}">${modeloVar.nome}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
							  		</div>
							  		
							    	<div class="form-group col-md-2">
							      		<label for="placa">Placa</label>
							      		<input type="text" class="form-control" id="placa" name="placa" value="${locacao.carro.placa}" required="required" disabled="disabled">
							    	</div>
							    	
							    	<div class="form-group col-md-2">
							      		<label for="quilometragem">Quilometragem</label>
							      		<input type="number" class="form-control" id="quilometragem" name="quilometragem" value="${locacao.carro.quilometragem}" disabled="disabled" >
							    	</div>
							    	
							  	</div>
							  	
							  	<hr>
							  	<h5>Cliente</h5>
							  	
							  	<div class="form-row">
							  		<div class="form-group col-md-3">
							      		<label for="cpf">CPF</label>
							      		<input type="text" class="form-control" id="cpf" name="cpf" onblur="carregarCliente()" value="${locacao.cliente.cpf}"
							      			data-inputmask='"mask": "999.999.999-99"' data-mask required="required" disabled="disabled" >
							    	</div>
							    	
							    	<div class="form-group col-md-9">
							      		<label for="nome">Nome</label>
							      		<input type="text" class="form-control" id="nome" name="nome" value="${locacao.cliente.nome}" disabled="disabled">
							    	</div>
							  	</div>
							  	
							  	<div class="form-row">
							  		<div class="form-group col-md-12">
							      		<label for="endereco">Endereço</label>
							      		<textarea class="form-control" id="endereco" name="endereco" rows="2" cols="200" disabled="disabled">value="${locacao.cliente.endereco}"</textarea>
							    	</div>
							    	
							  	</div>
							  	
							  	<hr>
								<h5>Locação</h5>
							  	
							  	<div class="form-row">
							  		
							  		<div class="form-group col-md-3">
							      		<label for="dataInicio">Data Início</label>
							      		<input type="text" class="form-control" id="dataInicioLocacaoStr" name="dataInicioLocacaoStr" disabled="disabled"
							      			value="${locacao.dataInicioLocacaoFormatada}" />
							    	</div>
							    	
							    	<div class="form-group col-md-3">
							      		<label for="dataFimLocacao">Data Fim</label>
							      		<input type="text" class="form-control" id="dataFimLocacaoStr" name="dataFimLocacaoStr" disabled="disabled"
							      			value="${locacao.dataFimLocacaoFormatada}" >
							    	</div>
							    	
							    	<div class="form-group col-md-6">
							  			<label for="modelo">Local de Retirada</label> 
										<select class="form-control" id="single-select-field" name="localRetirada.id" required="required" disabled="disabled" >
											<option value="">Selecione um local de retirada</option>
											<c:forEach var="localVar" items="${locais}">
												<c:choose>
													<c:when test="${locacao.localRetirada.id == localVar.id}">
														<option selected="selected" value="${localVar.id}">${localVar.nome}</option>
													</c:when>
													<c:otherwise>
														<option value="${localVar.id}">${localVar.nome}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
							  		</div>
							    	
							  	</div>

								<table id="tabela" class="table table-striped">
									<thead>
										<tr>
											<th width="100%">Item</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="itemVar" items="${locacao.itens}">
											<tr>
												<td>${itemVar.nome}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								
							</form:form>
																	
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
    
    <script type="text/javascript" src="<c:url value="/resources/vendor/inputmask/min/jquery.inputmask.bundle.min.js" />"> </script>
	
	<script type="text/javascript">
	
		$('[data-mask]').inputmask()
		
		$( '#select-carro' ).select2( {
		    theme: "bootstrap-5",
			    width: $( this ).data( 'width' ) ? $( this ).data( 'width' ) : $( this ).hasClass( 'w-100' ) ? '100%' : 'style',
			    placeholder: $( this ).data( 'placeholder' ),
		} );
		
		function carregarCliente() {
			
			
			
			if (document.getElementById('cpf').value != "") {
				var param = 'cpf=' + encodeURIComponent(document.getElementById('cpf').value);
				
				$.ajax({
		            url : "/locadora/locacao/carregar-cliente",
		            data : param,
		            dataType : "JSON",
		            type : "GET",
			
		            success : function(response) {
		            	
		            	if (response[0].nome == "") {
		            		alert("Cliente não cadastrado!");
		            		document.getElementById('cpf').value = "";
		            		document.getElementById('nome').value = "";
		            		document.getElementById('endereco').value = "";
		            		document.getElementById('idCliente').value = "";
		            	} else {
		            		document.getElementById('nome').value = response[0].nome;
		            		document.getElementById('endereco').value = response[0].endereco;
		            		document.getElementById('idCliente').value = response[0].idCliente;
		            	}
		            	
		        		
		            },
		            error : function(xhr, status, error) {
		                alert("ERRO: " + xhr.responseText);
		            }
		        });
			} else {
				document.getElementById('cpf').value = "";
        		document.getElementById('nome').value = "";
        		document.getElementById('endereco').value = "";
        		document.getElementById('idCliente').value = "";
			}
			
		}
	</script>
	
</body>

</html>