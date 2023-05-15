package br.com.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.locadora.dao.ModeloDAO;
import br.com.locadora.dao.UsuarioDAO;
import br.com.locadora.model.Modelo;

@Service
public class ModeloServiceImpl implements ModeloService {

	@Autowired
	private ModeloDAO modeloDAO;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	@Transactional
	public void salvar(Modelo modelo) {
		modeloDAO.salvar(modelo);
	}

	@Override
	@Transactional
	public List<Modelo> pesquisarModelos() {
		return modeloDAO.pesquisarModelos();
	}

	@Override
	@Transactional
	public void deletar(Long idModelo) {
		modeloDAO.deletar(idModelo);
	}

	@Override
	@Transactional
	public Modelo pesquisarModeloPorId(Long idModelo) {
		return modeloDAO.pesquisarModeloPorId(idModelo);
	}

}