package br.com.locadora.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.locadora.model.LocalRetirada;

@Repository
public class LocalRetiradaDAOImpl implements LocalRetiradaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void salvar(LocalRetirada localRetirada) {
		sessionFactory.getCurrentSession().saveOrUpdate(localRetirada);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LocalRetirada> pesquisarLocalRetiradas() {
		return sessionFactory.getCurrentSession().createQuery("from LocalRetirada").list();
	}

	@Override
	public void deletar(Long idLocalRetirada) {
		LocalRetirada localRetirada = (LocalRetirada) sessionFactory.getCurrentSession().load(LocalRetirada.class, idLocalRetirada);
		if (null != localRetirada) {
			this.sessionFactory.getCurrentSession().delete(localRetirada);
		}
	}

	@Override
	public LocalRetirada pesquisarLocalRetiradaPorId(Long idLocalRetirada) {
		return (LocalRetirada) sessionFactory.getCurrentSession().get(LocalRetirada.class, idLocalRetirada);
	}

}
