package br.com.locadora.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.locadora.model.LocalRetirada;
import br.com.locadora.service.LocalRetiradaService;

@Controller
@RequestMapping("/local-retirada")
public class LocalRetiradaController {

	@Autowired
	private LocalRetiradaService localRetiradaService;
	
	public LocalRetiradaController() {
	}

	@RequestMapping(value = "/listar")
	public ModelAndView listar(ModelAndView model) throws IOException {
		List<LocalRetirada> listLocalRetirada = localRetiradaService.pesquisarLocalRetiradas();
		model.addObject("listLocalRetirada", listLocalRetirada);
		model.setViewName("local-retirada-lista");
		return model;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelAndView model) {
		
		LocalRetirada localRetirada = new LocalRetirada();
		model.addObject("localRetirada", localRetirada);
		model.setViewName("local-retirada-formulario");
		return model;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute LocalRetirada localRetirada) {

		localRetiradaService.salvar(localRetirada);
		List<LocalRetirada> listLocalRetirada = localRetiradaService.pesquisarLocalRetiradas();

		ModelAndView model = new ModelAndView();
		model.addObject("listLocalRetirada", listLocalRetirada);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("local-retirada-lista");
		return model;
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletar(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));
		localRetiradaService.deletar(id);

		List<LocalRetirada> listLocalRetirada = localRetiradaService.pesquisarLocalRetiradas();

		ModelAndView model = new ModelAndView();
		model.addObject("listLocalRetirada", listLocalRetirada);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("local-retirada-lista");
		return model;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		LocalRetirada localRetirada = localRetiradaService.pesquisarLocalRetiradaPorId(id);
		ModelAndView model = new ModelAndView("local-retirada-formulario");
		model.addObject("localRetirada", localRetirada);

		return model;
	}
	
	@RequestMapping(value = "/exportar")
	public void exportar(HttpServletResponse response) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheetModelos = workbook.createSheet("LocalRetiradas");

		List<LocalRetirada> lista = localRetiradaService.pesquisarLocalRetiradas();
		
		int rownum = 0;

		Row cabecalho = sheetModelos.createRow(rownum++);

		Cell cellIdCab = cabecalho.createCell(0);
		cellIdCab.setCellValue("ID");

		Cell cellNomeCab = cabecalho.createCell(1);
		cellNomeCab.setCellValue("NOME");
		
		Cell cellLogradouroCab = cabecalho.createCell(2);
		cellLogradouroCab.setCellValue("ENDEREÇO");

		for (LocalRetirada localRetirada : lista) {
			Row row = sheetModelos.createRow(rownum++);
			int cellnum = 0;

			Cell cellId = row.createCell(cellnum++);
			cellId.setCellValue(localRetirada.getId());

			Cell cellNome = row.createCell(cellnum++);
			cellNome.setCellValue(localRetirada.getNome());
			
			Cell cellLogradouro = row.createCell(cellnum++);
			cellLogradouro.setCellValue(localRetirada.getEndereco().toString());
		}

		try {

			response.setHeader("Content-Disposition", "attachment;filename=\"localRetiradas.xlsx\"");

			response.setHeader("Pragma", "public");
			response.setHeader("Cache-Control", "cache");
			response.setHeader("Cache-Control", "must-revalidate");
			response.setContentType("application/vnd.ms-excel");
			response.setContentLength(workbook.getBytes().length);

			OutputStream out = response.getOutputStream();
			out.write(workbook.getBytes(), 0, workbook.getBytes().length);
			out.flush();
			out.close();

			System.out.println("Arquivo Excel criado com sucesso!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo não encontrado!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na edição do arquivo!");
		}

	}
}
