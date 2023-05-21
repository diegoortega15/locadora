package br.com.locadora.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.locadora.dao.CarroDAO;
import br.com.locadora.dao.ClienteDAO;
import br.com.locadora.dao.ItemAdicionalDAO;
import br.com.locadora.dao.LocacaoDAO;
import br.com.locadora.dao.LocalRetiradaDAO;
import br.com.locadora.model.ItemAdicional;
import br.com.locadora.model.Locacao;
import br.com.locadora.utils.DataUtils;

@Service
public class LocacaoServiceImpl implements LocacaoService {

	@Autowired
	private LocacaoDAO locacaoDAO;

	@Autowired
	private ClienteDAO clienteDAO;

	@Autowired
	private CarroDAO carroDAO;

	@Autowired
	private LocalRetiradaDAO localRetiradaDAO;
	
	@Autowired
	private ItemAdicionalDAO itemAdicionalDAO;

	@Override
	@Transactional
	public void salvar(Locacao locacao) {

		List<ItemAdicional> itens = new ArrayList<>();
		if (locacao.getId() != null) {
			Locacao locacaoBD = pesquisarLocacaoPorId(locacao.getId());
			itens = locacaoBD.getItens();
		}

		String idsIncluir[] = locacao.getIdsItens().split(",");
		String idsExcluir[] = locacao.getIdsItensExcluir().split(",");
		
		for (int i = 0; i < idsIncluir.length; i++) {
			if (!idsIncluir[i].equals("")) {
				ItemAdicional item = itemAdicionalDAO.pesquisarItemAdicionalPorId(Long.parseLong(idsIncluir[i]));
				itens.add(item);
			}
		}

		for (int i = 0; i < idsExcluir.length; i++) {
			if (!idsExcluir[i].equals("")) {
				ItemAdicional item = itemAdicionalDAO.pesquisarItemAdicionalPorId(Long.parseLong(idsExcluir[i]));
				itens.remove(item);
			}
		}
		
		locacao.setItens(itens);
		locacao.setIdentificador(String.valueOf(locacaoDAO.pesquisarLocacoes().size() + 1));
		locacao.setCliente(clienteDAO.pesquisarClientePorId(locacao.getCliente().getId()));
		locacao.setCarro(carroDAO.pesquisarCarroPorId(locacao.getCarro().getId()));
		locacao.setLocalRetirada(localRetiradaDAO.pesquisarLocalRetiradaPorId(locacao.getLocalRetirada().getId()));
		locacao.setDataInicioLocacao(DataUtils.converterStringParaLocalDateTime(locacao.getDataInicioLocacaoStr() + " 00:00"));
		locacao.setDataFimLocacao(DataUtils.converterStringParaLocalDateTime(locacao.getDataFimLocacaoStr() + " 00:00"));

		locacaoDAO.salvar(locacao);
	}

	@Override
	@Transactional
	public void devolver(Long idLocacao) {
		Locacao locacao = locacaoDAO.pesquisarLocacaoPorId(idLocacao);
		locacao.setAtivo(false);
		locacao.setDataEntrega(LocalDateTime.now());
		locacaoDAO.salvar(locacao);
	}

	@Override
	@Transactional
	public List<Locacao> pesquisarLocacoes() {
		return locacaoDAO.pesquisarLocacoes();
	}

	@Override
	@Transactional
	public Locacao pesquisarLocacaoPorId(Long idLocacao) {
		return locacaoDAO.pesquisarLocacaoPorId(idLocacao);
	}

	@Override
	@Transactional
	public List<Locacao> pesquisarLocacoesAtivos() {
		return locacaoDAO.pesquisarLocacoesAtivos();
	}

	@Override
	@Transactional
	public List<Locacao> pesquisarLocacaoPorIntervaloDatas(LocalDateTime dataInicio, LocalDateTime dataFim) {
		return locacaoDAO.pesquisarLocacaoPorIntervaloDatas(dataInicio, dataFim);
	}

	@Override
	@Transactional
	public List<Locacao> pesquisarLocacoesPorUsuario(Long idUsuario) {
		return locacaoDAO.pesquisarLocacoesPorUsuario(idUsuario);
	}

}