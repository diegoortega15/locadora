package br.com.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.locadora.dao.MarcaDAO;
import br.com.locadora.dao.UsuarioDAO;
import br.com.locadora.model.Marca;

@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired
	private MarcaDAO marcaDAO;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	@Transactional
	public void salvar(Marca marca) {
		marcaDAO.salvar(marca);
	}

	@Override
	@Transactional
	public List<Marca> pesquisarMarcas() {
		return marcaDAO.pesquisarMarcas();
	}

	@Override
	@Transactional
	public void deletar(Long idMarca) {
		marcaDAO.deletar(idMarca);
	}

	@Override
	@Transactional
	public Marca pesquisarMarcaPorId(Long idMarca) {
		return marcaDAO.pesquisarMarcaPorId(idMarca);
	}

}