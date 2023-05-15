package br.com.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.locadora.dao.LocalRetiradaDAO;
import br.com.locadora.dao.UsuarioDAO;
import br.com.locadora.model.LocalRetirada;

@Service
public class LocalRetiradaServiceImpl implements LocalRetiradaService {

	@Autowired
	private LocalRetiradaDAO localRetiradaDAO;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	@Transactional
	public void salvar(LocalRetirada localRetirada) {
		localRetiradaDAO.salvar(localRetirada);
	}

	@Override
	@Transactional
	public List<LocalRetirada> pesquisarLocalRetiradas() {
		return localRetiradaDAO.pesquisarLocalRetiradas();
	}

	@Override
	@Transactional
	public void deletar(Long idLocalRetirada) {
		localRetiradaDAO.deletar(idLocalRetirada);
	}

	@Override
	@Transactional
	public LocalRetirada pesquisarLocalRetiradaPorId(Long idLocalRetirada) {
		return localRetiradaDAO.pesquisarLocalRetiradaPorId(idLocalRetirada);
	}

}