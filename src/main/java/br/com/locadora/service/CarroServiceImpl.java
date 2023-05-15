package br.com.locadora.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.locadora.dao.CarroDAO;
import br.com.locadora.dao.MarcaDAO;
import br.com.locadora.dao.ModeloDAO;
import br.com.locadora.model.Carro;
import br.com.locadora.model.Marca;
import br.com.locadora.model.Modelo;

@Service
public class CarroServiceImpl implements CarroService {

	@Autowired
	private CarroDAO carroDAO;
	
	@Autowired
	private ModeloDAO modeloDAO;
	
	@Autowired
	private MarcaDAO marcaDAO;
	
	@Override
	@Transactional
	public void salvar(Carro carro) {
		
		Marca marca = marcaDAO.pesquisarMarcaPorId(carro.getMarca().getId());
		Modelo modelo = modeloDAO.pesquisarModeloPorId(carro.getModelo().getId());
		
		if (carro.getId() == null) {
			carro.setDataCadastro(LocalDateTime.now());
		}
		
		carro.setMarca(marca);
		carro.setModelo(modelo);
		carroDAO.salvar(carro);
	}

	@Override
	@Transactional
	public List<Carro> pesquisarCarros() {
		return carroDAO.pesquisarCarros();
	}

	@Override
	@Transactional
	public void deletar(Long idCarro) {
		carroDAO.deletar(idCarro);
	}

	@Override
	@Transactional
	public Carro pesquisarCarroPorId(Long idCarro) {
		return carroDAO.pesquisarCarroPorId(idCarro);
	}

	@Override
	@Transactional
	public List<Carro> pesquisarCarrosDisponiveis() {
		return carroDAO.pesquisarCarrosDisponiveis();
	}
	
	@Override
	@Transactional
	public List<Carro> pesquisarCarrosPorDataCadastro(LocalDateTime dataInicio, LocalDateTime dataFim) {
		return carroDAO.pesquisarCarrosPorDataCadastro(dataInicio, dataFim);
	}

}