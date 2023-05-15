package br.com.locadora.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.locadora.model.Carro;
import br.com.locadora.model.Cliente;

@Repository
public class CarroDAOImpl implements CarroDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void salvar(Carro carro) {
		sessionFactory.getCurrentSession().saveOrUpdate(carro);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carro> pesquisarCarros() {
		return sessionFactory.getCurrentSession().createQuery("from Carro").list();
	}

	@Override
	public void deletar(Long idCarro) {
		Carro carro = (Carro) sessionFactory.getCurrentSession().load(Carro.class, idCarro);
		if (null != carro) {
			this.sessionFactory.getCurrentSession().delete(carro);
		}
	}

	@Override
	public Carro pesquisarCarroPorId(Long idCarro) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Carro.class);
		criteria.add(Restrictions.eq("id", idCarro));

		Carro carro = (Carro) criteria.uniqueResult();
		return carro;

	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carro> pesquisarCarrosDisponiveis() {
		return sessionFactory.getCurrentSession().createQuery("from Carro where qtdDisponivel > 0").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Carro> pesquisarCarrosPorDataCadastro(LocalDateTime dataInicio, LocalDateTime dataFim) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Carro.class);
		criteria.add(Restrictions.ge("dataCadastro", dataInicio));
		criteria.add(Restrictions.lt("dataCadastro", dataFim));

		return criteria.list();
	}

}
