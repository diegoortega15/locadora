package br.com.locadora.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.locadora.model.Marca;

@Repository
public class MarcaDAOImpl implements MarcaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void salvar(Marca marca) {
		sessionFactory.getCurrentSession().saveOrUpdate(marca);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Marca> pesquisarMarcas() {
		return sessionFactory.getCurrentSession().createQuery("from Marca").list();
	}

	@Override
	public void deletar(Long idMarca) {
		Marca marca = (Marca) sessionFactory.getCurrentSession().load(Marca.class, idMarca);
		if (null != marca) {
			this.sessionFactory.getCurrentSession().delete(marca);
		}
	}

	@Override
	public Marca pesquisarMarcaPorId(Long idMarca) {
		return (Marca) sessionFactory.getCurrentSession().get(Marca.class, idMarca);
	}

}
