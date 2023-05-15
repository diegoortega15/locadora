package br.com.locadora.service;

import java.util.List;

import br.com.locadora.model.Modelo;

public interface ModeloService {

	public void salvar(Modelo modelo);

	public List<Modelo> pesquisarModelos();

	public void deletar(Long idModelo);

	public Modelo pesquisarModeloPorId(Long idModelo);
	
}