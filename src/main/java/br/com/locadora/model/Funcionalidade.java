package br.com.locadora.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionalidade")
public class Funcionalidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private boolean painel;

	// grupo operação
	private boolean grupoOperacao;

	private boolean locacao;

	private boolean locacoesRealizadas;

	private boolean minhasLocacoes;

	private boolean finalizarLocacao;

	private boolean relatorio;

	// grupo cadastros
	private boolean grupoCadastros;

	private boolean itemAdcional;

	private boolean localRetirada;

	private boolean marca;

	private boolean modelo;

	private boolean carro;

	// grupo controle de acesso
	private boolean grupoControleAcesso;

	private boolean cliente;

	private boolean funcionario;

	private boolean perfil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPainel() {
		return painel;
	}

	public void setPainel(boolean painel) {
		this.painel = painel;
	}

	public boolean isGrupoOperacao() {
		return grupoOperacao;
	}

	public void setGrupoOperacao(boolean grupoOperacao) {
		this.grupoOperacao = grupoOperacao;
	}

	public boolean isLocacao() {
		return locacao;
	}

	public void setLocacao(boolean locacao) {
		this.locacao = locacao;
	}

	public boolean isLocacoesRealizadas() {
		return locacoesRealizadas;
	}

	public void setLocacoesRealizadas(boolean locacoesRealizadas) {
		this.locacoesRealizadas = locacoesRealizadas;
	}

	public boolean isMinhasLocacoes() {
		return minhasLocacoes;
	}

	public void setMinhasLocacoes(boolean minhasLocacoes) {
		this.minhasLocacoes = minhasLocacoes;
	}

	public boolean isFinalizarLocacao() {
		return finalizarLocacao;
	}

	public void setFinalizarLocacao(boolean finalizarLocacao) {
		this.finalizarLocacao = finalizarLocacao;
	}

	public boolean isRelatorio() {
		return relatorio;
	}

	public void setRelatorio(boolean relatorio) {
		this.relatorio = relatorio;
	}

	public boolean isGrupoCadastros() {
		return grupoCadastros;
	}

	public void setGrupoCadastros(boolean grupoCadastros) {
		this.grupoCadastros = grupoCadastros;
	}

	public boolean isItemAdcional() {
		return itemAdcional;
	}

	public void setItemAdcional(boolean itemAdcional) {
		this.itemAdcional = itemAdcional;
	}

	public boolean isLocalRetirada() {
		return localRetirada;
	}

	public void setLocalRetirada(boolean localRetirada) {
		this.localRetirada = localRetirada;
	}

	public boolean isMarca() {
		return marca;
	}

	public void setMarca(boolean marca) {
		this.marca = marca;
	}

	public boolean isModelo() {
		return modelo;
	}

	public void setModelo(boolean modelo) {
		this.modelo = modelo;
	}

	public boolean isCarro() {
		return carro;
	}

	public void setCarro(boolean carro) {
		this.carro = carro;
	}

	public boolean isGrupoControleAcesso() {
		return grupoControleAcesso;
	}

	public void setGrupoControleAcesso(boolean grupoControleAcesso) {
		this.grupoControleAcesso = grupoControleAcesso;
	}

	public boolean isCliente() {
		return cliente;
	}

	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}

	public boolean isFuncionario() {
		return funcionario;
	}

	public void setFuncionario(boolean funcionario) {
		this.funcionario = funcionario;
	}

	public boolean isPerfil() {
		return perfil;
	}

	public void setPerfil(boolean perfil) {
		this.perfil = perfil;
	}

}
