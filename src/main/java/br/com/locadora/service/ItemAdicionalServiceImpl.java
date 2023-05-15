package br.com.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.locadora.dao.ItemAdicionalDAO;
import br.com.locadora.model.ItemAdicional;

@Service
public class ItemAdicionalServiceImpl implements ItemAdicionalService {

	@Autowired
	private ItemAdicionalDAO itemAdicionalDAO;

	@Override
	@Transactional
	public void salvar(ItemAdicional itemAdicional) {
		itemAdicionalDAO.salvar(itemAdicional);
	}

	@Override
	@Transactional
	public List<ItemAdicional> pesquisarItemAdicionals() {
		return itemAdicionalDAO.pesquisarItemAdicionals();
	}

	@Override
	@Transactional
	public void deletar(Long idItemAdicional) {
		itemAdicionalDAO.deletar(idItemAdicional);
	}

	@Override
	@Transactional
	public ItemAdicional pesquisarItemAdicionalPorId(Long idItemAdicional) {
		return itemAdicionalDAO.pesquisarItemAdicionalPorId(idItemAdicional);
	}

}