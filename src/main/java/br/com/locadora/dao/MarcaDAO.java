package br.com.locadora.dao;

import java.util.List;

import br.com.locadora.model.Marca;

public interface MarcaDAO {

	public void salvar(Marca marca);

	public List<Marca> pesquisarMarcas();

	public void deletar(Long idMarca);

	public Marca pesquisarMarcaPorId(Long idMarca);

}
