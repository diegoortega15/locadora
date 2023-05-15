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

import br.com.locadora.model.Carro;
import br.com.locadora.model.Marca;
import br.com.locadora.model.Modelo;
import br.com.locadora.service.CarroService;
import br.com.locadora.service.MarcaService;
import br.com.locadora.service.ModeloService;

@Controller
@RequestMapping("/carro")
public class CarroController {

	@Autowired
	private CarroService carroService;

	@Autowired
	private ModeloService modeloService;

	@Autowired
	private MarcaService marcaService;

	public CarroController() {
	}

	@RequestMapping(value = "/listar")
	public ModelAndView listarCarro(ModelAndView model) throws IOException {
		List<Carro> listCarro = carroService.pesquisarCarros();
		model.addObject("listCarro", listCarro);
		model.setViewName("carro-lista");
		return model;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelAndView model) {

		List<Modelo> modelos = modeloService.pesquisarModelos();
		List<Marca> marcas = marcaService.pesquisarMarcas();

		Carro carro = new Carro();
		model.addObject("carro", carro);
		model.addObject("modelos", modelos);
		model.addObject("marcas", marcas);
		model.setViewName("carro-formulario");
		return model;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute Carro carro) {

		ModelAndView model = new ModelAndView();

		carroService.salvar(carro);

		List<Carro> listCarro = carroService.pesquisarCarros();

		model.addObject("listCarro", listCarro);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("carro-lista");
		return model;
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public ModelAndView deletar(HttpServletRequest request) {

		Long id = Long.parseLong(request.getParameter("id"));
		carroService.deletar(id);

		List<Carro> listCarro = carroService.pesquisarCarros();

		ModelAndView model = new ModelAndView();
		model.addObject("listCarro", listCarro);
		model.addObject("sucesso", Boolean.TRUE);
		model.setViewName("carro-lista");
		return model;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		Carro carro = carroService.pesquisarCarroPorId(id);

		List<Modelo> modelos = modeloService.pesquisarModelos();
		List<Marca> marcas = marcaService.pesquisarMarcas();

		ModelAndView model = new ModelAndView("carro-formulario");
		model.addObject("modelos", modelos);
		model.addObject("marcas", marcas);
		model.addObject("carro", carro);

		return model;
	}
	
	@RequestMapping(value = "/exportar")
	public void exportar(HttpServletResponse response) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheetModelos = workbook.createSheet("Carros");

		List<Carro> lista = carroService.pesquisarCarros();
		
		int rownum = 0;

		Row cabecalho = sheetModelos.createRow(rownum++);

		Cell cellIdCab = cabecalho.createCell(0);
		cellIdCab.setCellValue("ID");

		Cell cellMarcaCab = cabecalho.createCell(1);
		cellMarcaCab.setCellValue("MARCA");

		Cell cellModeloCab = cabecalho.createCell(2);
		cellModeloCab.setCellValue("MODELO");
		
		Cell cellPlacaCab = cabecalho.createCell(3);
		cellPlacaCab.setCellValue("PLACA");
		
		Cell cellQuilometragemCab = cabecalho.createCell(4);
		cellQuilometragemCab.setCellValue("QUILOMETRAGEM");
		
		Cell cellStatusCab1 = cabecalho.createCell(5);
		cellStatusCab1.setCellValue("STATUS");

		for (Carro carro : lista) {
			Row row = sheetModelos.createRow(rownum++);
			int cellnum = 0;

			Cell cellId = row.createCell(cellnum++);
			cellId.setCellValue(carro.getId());

			Cell cellMarca = row.createCell(cellnum++);
			cellMarca.setCellValue(carro.getMarca().getNome());
			
			Cell cellModelo = row.createCell(cellnum++);
			cellModelo.setCellValue(carro.getModelo().getNome());
			
			Cell cellPlaca = row.createCell(cellnum++);
			cellPlaca.setCellValue(carro.getPlaca());
			
			Cell cellQuilometragem = row.createCell(cellnum++);
			cellQuilometragem.setCellValue(carro.getQuilometragem());
			
			Cell cellStatus = row.createCell(cellnum++);
			cellStatus.setCellValue(carro.getDisponivelStr());
			
		}

		try {

			response.setHeader("Content-Disposition", "attachment;filename=\"carros.xlsx\"");

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
			System.out.println("Arquivo n�o encontrado!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na edi��o do arquivo!");
		}

	}
}
