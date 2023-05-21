package br.com.locadora.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.locadora.model.Locacao;

@Repository
public class LocacaoDAOImpl implements LocacaoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void salvar(Locacao locacao) {
		sessionFactory.getCurrentSession().saveOrUpdate(locacao);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Locacao> pesquisarLocacoes() {
		return sessionFactory.getCurrentSession().createQuery("from Locacao").list();
	}

	@Override
	public void deletar(Long idLocacao) {
		Locacao locacao = (Locacao) sessionFactory.getCurrentSession().load(Locacao.class, idLocacao);
		if (null != locacao) {
			this.sessionFactory.getCurrentSession().delete(locacao);
		}
	}

	@Override
	public Locacao pesquisarLocacaoPorId(Long idLocacao) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Locacao.class);
		criteria.add(Restrictions.eq("id", idLocacao));

		Locacao locacao = (Locacao) criteria.uniqueResult();
		
		if (locacao != null) 
			Hibernate.initialize(locacao.getItens());
		
		return locacao;
	}

	@Override
	public Locacao pesquisarLocacaoAtivoPorCliente(Long idCliente) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Locacao.class);
		criteria.add(Restrictions.eq("cliente.id", idCliente));
		criteria.add(Restrictions.eq("ativo", Boolean.TRUE));

		Locacao locacao = (Locacao) criteria.uniqueResult();
		return locacao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Locacao> pesquisarLocacoesAtivos() {
		return sessionFactory.getCurrentSession().createQuery("from Locacao where ativo = true").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Locacao> pesquisarLocacaoPorIntervaloDatas(LocalDateTime dataInicio, LocalDateTime dataFim) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Locacao.class);
		criteria.add(Restrictions.ge("dataInicioLocacao", dataInicio));
		criteria.add(Restrictions.lt("dataInicioLocacao", dataFim));

		List<Locacao> locacaos = criteria.list();
		return locacaos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Locacao> pesquisarLocacoesPorUsuario(Long idUsuario) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Locacao.class);
		criteria.add(Restrictions.eq("cliente.id", idUsuario));

		List<Locacao> locacoes = criteria.list();
		return locacoes;
	}

}
