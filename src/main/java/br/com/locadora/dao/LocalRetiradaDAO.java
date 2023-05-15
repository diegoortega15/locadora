package br.com.locadora.dao;

import java.util.List;

import br.com.locadora.model.LocalRetirada;

public interface LocalRetiradaDAO {

	public void salvar(LocalRetirada localRetirada);

	public List<LocalRetirada> pesquisarLocalRetiradas();

	public void deletar(Long idLocalRetirada);

	public LocalRetirada pesquisarLocalRetiradaPorId(Long idLocalRetirada);

}
