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

import br.com.locadora.model.ItemAdicional;
import br.com.locadora.service.ItemAdicionalService;

@Controller
@RequestMapping("/item-adicional")
public class ItemAdicionalController {

	@Autowired
	private ItemAdicionalService itemAdicionalService;
	
	public ItemAdicionalController() {
	}

	@RequestMapping(value = "/listar")
	public ModelAndView listar(ModelAndView model) throws IOException {
		List<ItemAdicional> listItemAdicional = itemAdicionalService.pesquisarItemAdicionals();
		model.addObject("listItemAdicional", listItemAdicional);
		model.setViewName("item-adicional-lista");
		return model;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelAndView model) {
		
		ItemAdicional itemAdicional = new ItemAdicional();
		model.addObject("itemAdicional", itemAdicional);
		model.setViewName("item-adicional-formulario");
		return model;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute ItemAdicional itemAdicional) {

		itemAdicionalService.salvar(itemAdicional);
		List<ItemAdicional> listItemAdicional = itemAdicionalService.pesquisarItemAdicionals();

		ModelAndView model = new ModelAndView();
		model.addObject("listItemAdicional", listItemAdicional);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("item-adicional-lista");
		return model;
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletar(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));
		itemAdicionalService.deletar(id);

		List<ItemAdicional> listItemAdicional = itemAdicionalService.pesquisarItemAdicionals();

		ModelAndView model = new ModelAndView();
		model.addObject("listItemAdicional", listItemAdicional);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("item-adicional-lista");
		return model;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		ItemAdicional itemAdicional = itemAdicionalService.pesquisarItemAdicionalPorId(id);
		ModelAndView model = new ModelAndView("item-adicional-formulario");
		model.addObject("itemAdicional", itemAdicional);

		return model;
	}
	
	@RequestMapping(value = "/exportar")
	public void exportar(HttpServletResponse response) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheetModelos = workbook.createSheet("ItemAdicionals");

		List<ItemAdicional> lista = itemAdicionalService.pesquisarItemAdicionals();
		
		int rownum = 0;

		Row cabecalho = sheetModelos.createRow(rownum++);

		Cell cellIdCab = cabecalho.createCell(0);
		cellIdCab.setCellValue("ID");

		Cell cellNomeCab = cabecalho.createCell(1);
		cellNomeCab.setCellValue("NOME");

		for (ItemAdicional itemAdicional : lista) {
			Row row = sheetModelos.createRow(rownum++);
			int cellnum = 0;

			Cell cellId = row.createCell(cellnum++);
			cellId.setCellValue(itemAdicional.getId());

			Cell cellNome = row.createCell(cellnum++);
			cellNome.setCellValue(itemAdicional.getNome());
		}

		try {

			response.setHeader("Content-Disposition", "attachment;filename=\"item-adicional.xlsx\"");

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
