package br.com.locadora.service;

import java.time.LocalDateTime;
import java.util.List;

import br.com.locadora.model.Locacao;

public interface LocacaoService {

	public void salvar(Locacao locacao);

	public List<Locacao> pesquisarLocacoes();
	
	public List<Locacao> pesquisarLocacoesPorUsuario(Long idUsuario);

	public List<Locacao> pesquisarLocacoesAtivos();

	public Locacao pesquisarLocacaoPorId(Long idLocacao);

	public void devolver(Long idLocacao);

	public List<Locacao> pesquisarLocacaoPorIntervaloDatas(LocalDateTime dataInicio, LocalDateTime dataFim);

}