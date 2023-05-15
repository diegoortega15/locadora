package br.com.locadora.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.locadora.model.Modelo;

@Repository
public class ModeloDAOImpl implements ModeloDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void salvar(Modelo modelo) {
		sessionFactory.getCurrentSession().saveOrUpdate(modelo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Modelo> pesquisarModelos() {
		return sessionFactory.getCurrentSession().createQuery("from Modelo").list();
	}

	@Override
	public void deletar(Long idModelo) {
		Modelo modelo = (Modelo) sessionFactory.getCurrentSession().load(Modelo.class, idModelo);
		if (null != modelo) {
			this.sessionFactory.getCurrentSession().delete(modelo);
		}
	}

	@Override
	public Modelo pesquisarModeloPorId(Long idModelo) {
		return (Modelo) sessionFactory.getCurrentSession().get(Modelo.class, idModelo);
	}

}
