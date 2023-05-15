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
import br.com.locadora.model.Modelo;
import br.com.locadora.service.MarcaService;
import br.com.locadora.service.ModeloService;

@Controller
@RequestMapping("/modelo")
public class ModeloController {

	@Autowired
	private ModeloService modeloService;

	@Autowired
	private MarcaService marcaService;
	
	public ModeloController() {
	}

	@RequestMapping(value = "/listar")
	public ModelAndView listar(ModelAndView model) throws IOException {
		List<Modelo> listModelo = modeloService.pesquisarModelos();
		model.addObject("listModelo", listModelo);
		model.setViewName("modelo-lista");
		return model;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelAndView model) {
		
		List<Marca> marcas = marcaService.pesquisarMarcas();
		
		Modelo modelo = new Modelo();
		model.addObject("modelo", modelo);
		model.addObject("marcas", marcas);
		model.setViewName("modelo-formulario");
		return model;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute Modelo modelo) {

		modeloService.salvar(modelo);
		List<Modelo> listModelo = modeloService.pesquisarModelos();

		ModelAndView model = new ModelAndView();
		model.addObject("listModelo", listModelo);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("modelo-lista");
		return model;
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletar(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));
		modeloService.deletar(id);

		List<Modelo> listModelo = modeloService.pesquisarModelos();

		ModelAndView model = new ModelAndView();
		model.addObject("listModelo", listModelo);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("modelo-lista");
		return model;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		Modelo modelo = modeloService.pesquisarModeloPorId(id);
		
		List<Marca> marcas = marcaService.pesquisarMarcas();
		
		ModelAndView model = new ModelAndView("modelo-formulario");
		model.addObject("modelo", modelo);
		model.addObject("marcas", marcas);
		
		return model;
	}

	@RequestMapping(value = "/exportar")
	public void exportar(HttpServletResponse response) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheetModelos = workbook.createSheet("Modelos");

		List<Modelo> lista = modeloService.pesquisarModelos();
		
		int rownum = 0;

		Row cabecalho = sheetModelos.createRow(rownum++);

		Cell cellIdCab = cabecalho.createCell(0);
		cellIdCab.setCellValue("ID");

		Cell cellNomeCab = cabecalho.createCell(1);
		cellNomeCab.setCellValue("NOME");
		
		Cell cellMarcaCab = cabecalho.createCell(2);
		cellMarcaCab.setCellValue("MARCA");

		for (Modelo modelo : lista) {
			Row row = sheetModelos.createRow(rownum++);
			int cellnum = 0;

			Cell cellId = row.createCell(cellnum++);
			cellId.setCellValue(modelo.getId());

			Cell cellNome = row.createCell(cellnum++);
			cellNome.setCellValue(modelo.getNome());
			
			Cell cellMarca = row.createCell(cellnum++);
			cellMarca.setCellValue(modelo.getMarca().getNome());
		}

		try {

			response.setHeader("Content-Disposition", "attachment;filename=\"modelos.xlsx\"");

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
