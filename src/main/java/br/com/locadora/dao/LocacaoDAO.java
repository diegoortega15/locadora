package br.com.locadora.dao;

import java.time.LocalDateTime;
import java.util.List;

import br.com.locadora.model.Locacao;

public interface LocacaoDAO {

	public void salvar(Locacao locacao);

	public List<Locacao> pesquisarLocacoes();
	
	public List<Locacao> pesquisarLocacoesAtivos();

	public void deletar(Long idLocacao);

	public Locacao pesquisarLocacaoPorId(Long idLocacao);
	
	public Locacao pesquisarLocacaoAtivoPorCliente(Long idCliente);
	
	public List<Locacao> pesquisarLocacaoPorIntervaloDatas(LocalDateTime dataInicio, LocalDateTime dataFim);

	public List<Locacao> pesquisarLocacoesPorUsuario(Long idUsuario);

}
