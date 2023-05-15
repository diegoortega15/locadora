package br.com.locadora.dao;

import java.util.List;

import br.com.locadora.model.Modelo;

public interface ModeloDAO {

	public void salvar(Modelo modelo);

	public List<Modelo> pesquisarModelos();

	public void deletar(Long idModelo);

	public Modelo pesquisarModeloPorId(Long idModelo);

}
