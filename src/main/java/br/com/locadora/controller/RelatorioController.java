package br.com.locadora.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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
import br.com.locadora.model.Locacao;
import br.com.locadora.model.Relatorio;
import br.com.locadora.service.CarroService;
import br.com.locadora.service.ClienteService;
import br.com.locadora.service.LocacaoService;
import br.com.locadora.utils.DataUtils;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

	@Autowired
	private LocacaoService locacaoService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private CarroService carroService;

	public RelatorioController() {
	}

	@RequestMapping(value = "/formulario")
	public ModelAndView geral(ModelAndView model) throws IOException {
		model.setViewName("relatorio-formulario");
		model.addObject("dataInicio", LocalDate.now());
		model.addObject("dataFim", LocalDate.now());
		return model;
	}

	@RequestMapping(value = "/gerar")
	public ModelAndView gerarRelatorio(@ModelAttribute Relatorio relatorio) throws IOException {

		ModelAndView model = new ModelAndView();
		model.addObject("dataInicio", relatorio.getDataInicio());
		model.addObject("dataFim", relatorio.getDataFim());
		model.addObject("dataInicioFormat",
				DataUtils.converterLocalDateParaString(LocalDate.parse(relatorio.getDataInicio())));
		model.addObject("dataFimFormat",
				DataUtils.converterLocalDateParaString(LocalDate.parse(relatorio.getDataFim())));

		model.setViewName("relatorio");
		return model;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/geral/dados", method = RequestMethod.GET)
	public @ResponseBody String getDados(@RequestParam("dataInicio") String dataInicio,
			@RequestParam("dataFim") String dataFim) throws IOException {

		// total de locacaos realizados no intervalo
		List<Locacao> locacaos = locacaoService.pesquisarLocacaoPorIntervaloDatas(
				DataUtils.converterStringParaLocalDateTime(dataInicio + " 00:00"),
				DataUtils.converterStringParaLocalDateTime(dataFim + " 23:59"));

		List<Cliente> clientes = clienteService.pesquisarClientesPorDataCadastro(
				DataUtils.converterStringParaLocalDateTime(dataInicio + " 00:00"),
				DataUtils.converterStringParaLocalDateTime(dataFim + " 23:59"));
		
		List<Carro> carros = carroService.pesquisarCarrosPorDataCadastro(
				DataUtils.converterStringParaLocalDateTime(dataInicio + " 00:00"),
				DataUtils.converterStringParaLocalDateTime(dataFim + " 23:59"));

		long locacaoAndamento = 0;
		long locacaoFinalizados = 0;
		for (Locacao locacao : locacaos) {
			if (locacao.isAtivo())
				locacaoAndamento++;
			else
				locacaoFinalizados++;
		}

		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("dados", " ");
		jsonObject.put("locacao", locacaos.size());
		jsonObject.put("locacaoAndamento", locacaoAndamento);
		jsonObject.put("locacaoFinalizados", locacaoFinalizados);
		jsonObject.put("clientes", clientes.size());
		jsonObject.put("carros", carros.size());
		
		jsonArray.add(jsonObject);

		return jsonArray.toJSONString();
	}

}
