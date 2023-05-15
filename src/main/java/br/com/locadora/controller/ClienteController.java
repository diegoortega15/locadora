package br.com.locadora.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.locadora.model.Cliente;
import br.com.locadora.model.Perfil;
import br.com.locadora.model.Usuario;
import br.com.locadora.service.ClienteService;
import br.com.locadora.service.PerfilService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private PerfilService perfilService;

	public ClienteController() {
	}

	@RequestMapping(value = "/listar")
	public ModelAndView listar(ModelAndView model) throws IOException {
		List<Cliente> listCliente = clienteService.pesquisarClientes();
		model.addObject("listCliente", listCliente);
		model.setViewName("cliente-lista");
		return model;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelAndView model) {

		List<Perfil> perfis = perfilService.pesquisarPerfils();

		Cliente cliente = new Cliente();
		model.addObject("perfis", perfis);
		model.addObject("cliente", cliente);
		model.setViewName("cliente-formulario");
		return model;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute Cliente cliente) {

		ModelAndView model = new ModelAndView();

		List<String> erros = new ArrayList<String>();
		boolean erro = false;
		if (isCpfCadastrado(cliente)) {
			erro = true;
			erros.add("Já existe um cliente cadastrado para o CPF informado.");
		}
		if (isLoginCadastrado(cliente)) {
			erro = true;
			erros.add("Já existe um cliente cadastrado para o login informado.");
		}
		if (isEmailCadastrado(cliente)) {
			erro = true;
			erros.add("Já existe um cliente cadastrado para o e-mail informado.");
		}

		if (erro) {
			List<Perfil> perfis = perfilService.pesquisarPerfils();
			cliente.getPerfil().setId(cliente.getPerfil().getId());

			model.addObject("cliente", cliente);
			model.addObject("perfis", perfis);
			model.addObject("erro", erro);
			model.addObject("erros", erros);
			model.addObject("cliente", cliente);
			model.setViewName("cliente-formulario");

		} else {
			clienteService.salvar(cliente);
			List<Cliente> listCliente = clienteService.pesquisarClientes();

			model.addObject("listCliente", listCliente);
			model.addObject("sucesso", Boolean.TRUE);
			model.setViewName("cliente-lista");
		}

		return model;
	}

	private boolean isCpfCadastrado(Cliente cliente) {

		Cliente clienteBD = clienteService.pesquisarClientePorCPF(cliente.getCpf());

		if (clienteBD != null) {
			if (cliente.getId() != null) {
				if (clienteBD.getCpf().equals(cliente.getCpf())) {
					if (clienteBD.getId() == cliente.getId())
						return false;
					else
						return true;
				}
			}

			return true;
		} else {
			return false;
		}

	}

	private boolean isEmailCadastrado(Cliente cliente) {

		Cliente clienteBD = clienteService.pesquisarClientePorEmail(cliente.getEmail());

		if (clienteBD != null) {
			if (cliente.getId() != null) {
				if (clienteBD.getEmail().equals(cliente.getEmail())) {
					if (clienteBD.getId() == cliente.getId())
						return false;
					else
						return true;
				}
			}

			return true;
		} else {
			return false;
		}

	}

	private boolean isLoginCadastrado(Cliente cliente) {

		Cliente clienteBD = clienteService.pesquisarClientePorLogin(cliente.getLogin());

		if (clienteBD != null) {
			if (cliente.getId() != null) {
				if (clienteBD.getLogin().equals(cliente.getLogin())) {
					if (clienteBD.getId() == cliente.getId())
						return false;
					else
						return true;
				}
			}

			return true;
		} else {
			return false;
		}

	}

	@RequestMapping(value = "/atualizar-dados", method = RequestMethod.POST)
	public ModelAndView atualizar(@ModelAttribute Cliente cliente) {
		clienteService.atualizarDados(cliente);

		List<Perfil> perfis = perfilService.pesquisarPerfils();

		ModelAndView model = new ModelAndView();
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("cliente-dados-pessoais-form");
		model.addObject("perfis", perfis);

		return model;
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletar(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));
		clienteService.deletar(id);

		List<Cliente> listCliente = clienteService.pesquisarClientes();

		ModelAndView model = new ModelAndView();
		model.addObject("listCliente", listCliente);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("cliente-lista");
		return model;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		Cliente cliente = clienteService.pesquisarClientePorId(id);

		List<Perfil> perfis = perfilService.pesquisarPerfils();

		ModelAndView model = new ModelAndView("cliente-formulario");
		model.addObject("cliente", cliente);
		model.addObject("perfis", perfis);

		return model;
	}

	@RequestMapping(value = "/cadastrar")
	public ModelAndView cadastrar(ModelAndView model) throws IOException {
		model.setViewName("cadastro");
		return model;
	}

	@RequestMapping(value = "/salvar-externo", method = RequestMethod.POST)
	public ModelAndView salvarExterno(@ModelAttribute Cliente cliente, HttpSession session)
			throws GeneralSecurityException, IOException {

		ModelAndView model = null;

		clienteService.salvarExterno(cliente);
		session.setAttribute("usuarioLogado", (Usuario) cliente) ;
		
		model = new ModelAndView();
		model.setViewName("painel");
		return model;
	}
}
