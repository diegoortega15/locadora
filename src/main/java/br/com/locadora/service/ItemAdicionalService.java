package br.com.locadora.service;

import java.util.List;

import br.com.locadora.model.ItemAdicional;

public interface ItemAdicionalService {

	public void salvar(ItemAdicional itemAdicional);

	public List<ItemAdicional> pesquisarItemAdicionals();

	public void deletar(Long idItemAdicional);

	public ItemAdicional pesquisarItemAdicionalPorId(Long idItemAdicional);
	
}