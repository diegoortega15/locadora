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

import br.com.locadora.model.Marca;
import br.com.locadora.service.MarcaService;

@Controller
@RequestMapping("/marca")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;
	
	public MarcaController() {
	}

	@RequestMapping(value = "/listar")
	public ModelAndView listar(ModelAndView model) throws IOException {
		List<Marca> listMarca = marcaService.pesquisarMarcas();
		model.addObject("listMarca", listMarca);
		model.setViewName("marca-lista");
		return model;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelAndView model) {
		
		Marca marca = new Marca();
		model.addObject("marca", marca);
		model.setViewName("marca-formulario");
		return model;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute Marca marca) {

		marcaService.salvar(marca);
		List<Marca> listMarca = marcaService.pesquisarMarcas();

		ModelAndView model = new ModelAndView();
		model.addObject("listMarca", listMarca);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("marca-lista");
		return model;
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletar(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));
		marcaService.deletar(id);

		List<Marca> listMarca = marcaService.pesquisarMarcas();

		ModelAndView model = new ModelAndView();
		model.addObject("listMarca", listMarca);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("marca-lista");
		return model;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		Marca marca = marcaService.pesquisarMarcaPorId(id);
		ModelAndView model = new ModelAndView("marca-formulario");
		model.addObject("marca", marca);

		return model;
	}
	
	@RequestMapping(value = "/exportar")
	public void exportar(HttpServletResponse response) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheetModelos = workbook.createSheet("Marcas");

		List<Marca> lista = marcaService.pesquisarMarcas();
		
		int rownum = 0;

		Row cabecalho = sheetModelos.createRow(rownum++);

		Cell cellIdCab = cabecalho.createCell(0);
		cellIdCab.setCellValue("ID");

		Cell cellNomeCab = cabecalho.createCell(1);
		cellNomeCab.setCellValue("NOME");

		for (Marca marca : lista) {
			Row row = sheetModelos.createRow(rownum++);
			int cellnum = 0;

			Cell cellId = row.createCell(cellnum++);
			cellId.setCellValue(marca.getId());

			Cell cellNome = row.createCell(cellnum++);
			cellNome.setCellValue(marca.getNome());
		}

		try {

			response.setHeader("Content-Disposition", "attachment;filename=\"marcas.xlsx\"");

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
