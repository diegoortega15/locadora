package br.com.locadora.service;

import java.time.LocalDateTime;
import java.util.List;

import br.com.locadora.model.Carro;

public interface CarroService {

	public void salvar(Carro carro);

	public List<Carro> pesquisarCarros();

	public void deletar(Long idCarro);

	public Carro pesquisarCarroPorId(Long idCarro);
	
	public List<Carro> pesquisarCarrosDisponiveis();

	public List<Carro> pesquisarCarrosPorDataCadastro(LocalDateTime dataInicio, LocalDateTime dataFim);
	
}