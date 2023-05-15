package br.com.locadora.service;

import java.util.List;

import br.com.locadora.model.LocalRetirada;

public interface LocalRetiradaService {

	public void salvar(LocalRetirada localRetirada);

	public List<LocalRetirada> pesquisarLocalRetiradas();

	public void deletar(Long idLocalRetirada);

	public LocalRetirada pesquisarLocalRetiradaPorId(Long idLocalRetirada);
	
}