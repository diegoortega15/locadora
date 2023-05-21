package br.com.locadora.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.locadora.model.Carro;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.ItemAdicional;
import br.com.locadora.model.Locacao;
import br.com.locadora.model.LocalRetirada;
import br.com.locadora.model.Marca;
import br.com.locadora.model.Modelo;
import br.com.locadora.model.Usuario;
import br.com.locadora.service.CarroService;
import br.com.locadora.service.ClienteService;
import br.com.locadora.service.ItemAdicionalService;
import br.com.locadora.service.LocacaoService;
import br.com.locadora.service.LocalRetiradaService;
import br.com.locadora.service.MarcaService;
import br.com.locadora.service.ModeloService;

@Controller
@RequestMapping("/locacao")
public class LocacaoController {

	@Autowired
	private LocacaoService locacaoService;

	@Autowired
	private CarroService carroService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private MarcaService marcaService;

	@Autowired
	private ModeloService modeloService;

	@Autowired
	private LocalRetiradaService localRetiradaService;
	
	@Autowired
	private ItemAdicionalService itemAdicionalService;

	public LocacaoController() {
	}

	@RequestMapping(value = "/listar-carros", method = RequestMethod.GET)
	public ModelAndView listarCarros(ModelAndView model) {
		List<Carro> carros = carroService.pesquisarCarros();

		model.addObject("carros", carros);
		model.setViewName("locacao-carro-lista");
		return model;
	}

	@RequestMapping(value = "/formulario", method = RequestMethod.GET)
	public ModelAndView formulario(HttpServletRequest request) {

		ModelAndView model = new ModelAndView("locacao-formulario");

		Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
		// verificar se é um cliente
		if (usuarioLogado instanceof Cliente) {
			model.addObject("isCliente", true);
			model.addObject("idCliente", usuarioLogado.getId());
		} else {
			model.addObject("isCliente", false);
		}
		List<Marca> marcas = marcaService.pesquisarMarcas();
		List<Modelo> modelos = modeloService.pesquisarModelos();
		List<LocalRetirada> locais = localRetiradaService.pesquisarLocalRetiradas();
		List<ItemAdicional> itens = itemAdicionalService.pesquisarItemAdicionals();
		
		Long idCarro = Long.parseLong(request.getParameter("idCarro"));
		Carro carro = carroService.pesquisarCarroPorId(idCarro);

		model.addObject("carro", carro);
		model.addObject("marcas", marcas);
		model.addObject("modelos", modelos);
		model.addObject("locais", locais);
		model.addObject("itens", itens);
		
		return model;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/carregar-cliente", method = RequestMethod.GET)
	public @ResponseBody String carregarCliente(@RequestParam("cpf") String cpf) throws IOException {

		Cliente cliente = clienteService.pesquisarClientePorCPF(cpf);

		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();

		if (cliente != null) {
			jsonObject.put("nome", cliente.getNome());
			jsonObject.put("endereco", cliente.getEndereco().toString());
			jsonObject.put("idCliente", cliente.getId());
		} else {
			jsonObject.put("nome", "");
			jsonObject.put("endereco", "");
			jsonObject.put("idCliente", "");
		}

		jsonArray.add(jsonObject);
		return jsonArray.toJSONString();
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute Locacao locacao) {

		locacaoService.salvar(locacao);

		List<Marca> marcas = marcaService.pesquisarMarcas();
		List<Modelo> modelos = modeloService.pesquisarModelos();
		List<LocalRetirada> locais = localRetiradaService.pesquisarLocalRetiradas();

		ModelAndView model = new ModelAndView("locacao-formulario-sucesso");
		model.addObject("locacao", locacaoService.pesquisarLocacaoPorId(locacao.getId()));
		model.addObject("marcas", marcas);
		model.addObject("modelos", modelos);
		model.addObject("locais", locais);
		return model;
	}

	@RequestMapping(value = "/listar")
	public ModelAndView listar(ModelAndView model) throws IOException {
		List<Locacao> locacoes = locacaoService.pesquisarLocacoes();
		model.addObject("locacoes", locacoes);
		model.setViewName("locacao-lista");
		return model;
	}
	
	@RequestMapping(value = "/listar-ativo")
	public ModelAndView listarAtivo(ModelAndView model) throws IOException {
		List<Locacao> locacoes = locacaoService.pesquisarLocacoesAtivos();
		model.addObject("locacoes", locacoes);
		model.setViewName("locacao-lista-ativo");
		return model;
	}

	@RequestMapping(value = "/minhas-locacoes")
	public ModelAndView minhasLocacoes(ModelAndView model, HttpServletRequest request) throws IOException {

		Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");

		List<Locacao> locacoes = locacaoService.pesquisarLocacoesPorUsuario(usuarioLogado.getId());
		model.addObject("locacoes", locacoes);
		model.setViewName("locacao-lista");
		return model;
	}

	@RequestMapping(value = "/visualizar", method = RequestMethod.GET)
	public ModelAndView visualizar(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));
		Locacao locacao = locacaoService.pesquisarLocacaoPorId(id);

		List<Marca> marcas = marcaService.pesquisarMarcas();
		List<Modelo> modelos = modeloService.pesquisarModelos();
		List<LocalRetirada> locais = localRetiradaService.pesquisarLocalRetiradas();

		ModelAndView model = new ModelAndView("locacao-view");
		model.addObject("locacao", locacao);
		model.addObject("marcas", marcas);
		model.addObject("modelos", modelos);
		model.addObject("locais", locais);

		return model;
	}

	@RequestMapping(value = "/finalizar", method = RequestMethod.GET)
	public ModelAndView finalizar(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));
		locacaoService.devolver(id);

		ModelAndView model = new ModelAndView("locacao-lista-ativo");
		List<Locacao> locacoes = locacaoService.pesquisarLocacoesAtivos();
		model.addObject("locacoes", locacoes);
		model.addObject("sucesso", true);
		
		return model;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/incluir-item", method = RequestMethod.GET)
	public @ResponseBody String incluirItem(@RequestParam("item") String idItem) throws IOException {
		
		ItemAdicional itemAdicional = itemAdicionalService.pesquisarItemAdicionalPorId(Long.parseLong(idItem));
		
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("nome", itemAdicional.getNome());
		jsonObject.put("id", itemAdicional.getId());

		jsonArray.add(jsonObject);
		return jsonArray.toJSONString();
	}
	
}
