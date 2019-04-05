package br.kmdr.financeiro.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.kmdr.core.domain.ContaMovimentacaoStatus;
import br.kmdr.core.entity.BaseEntity;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Conta extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6082682669920492121L;

	@Column(length = 150, nullable = false)
	private String nome;

	@Column(length = 250, nullable = true)
	private String descricao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conta", orphanRemoval = true)
	private List<Lancamento> lancamentos;

	@ManyToOne
	private Moeda moeda;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_abertura", nullable = true)
	private Date dataAberturaConta;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_encerramento", nullable = true)
	private Date dataEncerramentoConta;

	@Column(name = "saldo_inicial", nullable = true, length = 12, precision = 10, scale = 2)
	private BigDecimal saldoInicial;

	// TODO: Acho melhor colocar no DominioValor. Mudar Depois.
	@Enumerated(EnumType.STRING)
	@Column(length = 12, nullable = false)
	private ContaMovimentacaoStatus situacao = ContaMovimentacaoStatus.ABERTA;

	@Column(name = "limite_credito", nullable = true, length = 12, precision = 10, scale = 2)
	private BigDecimal limiteCredito;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_vencimento_limite", nullable = true)
	private Date dataVencimentoLimite;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Moeda getMoeda() {
		return moeda;
	}

	public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}

	public Date getDataAberturaConta() {
		return dataAberturaConta;
	}

	public void setDataAberturaConta(Date dataAberturaConta) {
		this.dataAberturaConta = dataAberturaConta;
	}

	public ContaMovimentacaoStatus getSituacao() {
		return situacao;
	}

	public void setSituacao(ContaMovimentacaoStatus situacao) {
		this.situacao = situacao;
	}

	public Date getDataVencimentoLimite() {
		return dataVencimentoLimite;
	}

	public void setDataVencimentoLimite(Date dataVencimentoLimite) {
		this.dataVencimentoLimite = dataVencimentoLimite;
	}

	public Date getDataEncerramentoConta() {
		return dataEncerramentoConta;
	}

	public void setDataEncerramentoConta(Date dataEncerramentoConta) {
		this.dataEncerramentoConta = dataEncerramentoConta;
	}

	public BigDecimal getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(BigDecimal saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

}
