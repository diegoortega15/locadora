package br.com.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.locadora.dao.PerfilDAO;
import br.com.locadora.model.Perfil;

@Service
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	private PerfilDAO perfilDAO;
	
	@Override
	@Transactional
	public void salvar(Perfil perfil) {
		perfilDAO.salvar(perfil);
	}

	@Override
	@Transactional
	public List<Perfil> pesquisarPerfils() {
		return perfilDAO.pesquisarPerfils();
	}

	@Override
	@Transactional
	public void deletar(Long idPerfil) {
		perfilDAO.deletar(idPerfil);
	}

	@Override
	@Transactional
	public Perfil pesquisarPerfilPorId(Long idPerfil) {
		return perfilDAO.pesquisarPerfilPorId(idPerfil);
	}

}