package br.com.locadora.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.locadora.utils.DataUtils;
import br.com.locadora.utils.LocalDateTimeConverter;

@Entity
@Table(name = "locacao")
public class Locacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "identificador")
	private String identificador;

	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "id_carro", referencedColumnName = "id")
	private Carro carro;

	@ManyToOne
	@JoinColumn(name = "id_local_retirada", referencedColumnName = "id")
	private LocalRetirada localRetirada;

	@Column(name = "data_inicio_locacao")
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime dataInicioLocacao;

	@Transient
	private String dataInicioLocacaoStr;

	@Column(name = "data_fim_locacao")
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime dataFimLocacao;

	@Transient
	private String dataFimLocacaoStr;

	@Column(name = "data_entrega")
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime dataEntrega;

	@Column(name = "ativo")
	private boolean ativo = true;

	@ManyToMany
	private List<ItemAdicional> itens = new ArrayList<ItemAdicional>();

	@Transient
	private String dataInicioLocacaoFormatada;

	@Transient
	private String dataFimLocacaoFormatada;

	@Transient
	private String dataEntregaFormatada;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public LocalDateTime getDataInicioLocacao() {
		return dataInicioLocacao;
	}

	public void setDataInicioLocacao(LocalDateTime dataInicioLocacao) {
		this.dataInicioLocacao = dataInicioLocacao;
	}

	public LocalDateTime getDataFimLocacao() {
		return dataFimLocacao;
	}

	public void setDataFimLocacao(LocalDateTime dataFimLocacao) {
		this.dataFimLocacao = dataFimLocacao;
	}

	public LocalDateTime getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDateTime dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getDataInicioLocacaoFormatada() {
		return DataUtils.converterLocalDateTimeParaStringDateTime(dataInicioLocacao);
	}

	public void setDataInicioLocacaoFormatada(String dataInicioLocacaoFormatada) {
		this.dataInicioLocacaoFormatada = dataInicioLocacaoFormatada;
	}

	public String getDataFimLocacaoFormatada() {
		return DataUtils.converterLocalDateTimeParaStringDateTime(dataFimLocacao);
	}

	public void setDataFimLocacaoFormatada(String dataFimLocacaoFormatada) {
		this.dataFimLocacaoFormatada = dataFimLocacaoFormatada;
	}

	public String getDataEntregaFormatada() {
		return DataUtils.converterLocalDateTimeParaStringDateTime(dataEntrega);
	}

	public void setDataEntregaFormatada(String dataEntregaFormatada) {
		this.dataEntregaFormatada = dataEntregaFormatada;
	}

	public String getDataInicioLocacaoStr() {
		return dataInicioLocacaoStr;
	}

	public void setDataInicioLocacaoStr(String dataInicioLocacaoStr) {
		this.dataInicioLocacaoStr = dataInicioLocacaoStr;
	}

	public String getDataFimLocacaoStr() {
		return dataFimLocacaoStr;
	}

	public void setDataFimLocacaoStr(String dataFimLocacaoStr) {
		this.dataFimLocacaoStr = dataFimLocacaoStr;
	}

	public LocalRetirada getLocalRetirada() {
		return localRetirada;
	}

	public void setLocalRetirada(LocalRetirada localRetirada) {
		this.localRetirada = localRetirada;
	}

	public String getStatusStr() {
		return ativo ? "Ativo" : "Inativo";
	}

	public List<ItemAdicional> getItens() {
		return itens;
	}

	public void setItens(List<ItemAdicional> itens) {
		this.itens = itens;
	}

}
