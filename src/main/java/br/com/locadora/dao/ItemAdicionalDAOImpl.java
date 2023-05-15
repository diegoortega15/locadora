package br.com.locadora.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.locadora.model.ItemAdicional;

@Repository
public class ItemAdicionalDAOImpl implements ItemAdicionalDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void salvar(ItemAdicional itemAdicional) {
		sessionFactory.getCurrentSession().saveOrUpdate(itemAdicional);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemAdicional> pesquisarItemAdicionals() {
		return sessionFactory.getCurrentSession().createQuery("from ItemAdicional").list();
	}

	@Override
	public void deletar(Long idItemAdicional) {
		ItemAdicional itemAdicional = (ItemAdicional) sessionFactory.getCurrentSession().load(ItemAdicional.class, idItemAdicional);
		if (null != itemAdicional) {
			this.sessionFactory.getCurrentSession().delete(itemAdicional);
		}
	}

	@Override
	public ItemAdicional pesquisarItemAdicionalPorId(Long idItemAdicional) {
		return (ItemAdicional) sessionFactory.getCurrentSession().get(ItemAdicional.class, idItemAdicional);
	}

}
