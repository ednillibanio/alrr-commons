package br.kmdr.financeiro.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.kmdr.commons.entity.DominioValor;
import br.kmdr.commons.pessoa.entity.Pessoa;
import br.kmdr.commons.utils.helper.DataHelper;
import br.kmdr.contabil.entity.CentroDeCustos;
import br.kmdr.contabil.entity.PlanoDeContas;
import br.kmdr.core.domain.LancamentoSituacao;
import br.kmdr.core.domain.LancamentoType;
import br.kmdr.core.entity.BaseEntity;

// TODO: Ver se o nome está de acordo. Se for lancamento Contabil tem que ter histórico. 
@Entity
@Table
public class Lancamento extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 619391641398107742L;


	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_lancamento", length = 2, nullable = false)
	private LancamentoType tipoLancamento;

	@Enumerated(EnumType.STRING)
	@Column(name = "situacao", length = 2, nullable = false)
	private LancamentoSituacao situacao;

	@Column(name = "mes_ref", nullable = true)
	private int mesRef;

	@Column(name = "ano_ref", nullable = true)
	private int anoRef;

	@Column(nullable = true, length = 20)
	private int numero;

	
	
	@Column(nullable = false, length = 12, precision = 10, scale = 2)
	private BigDecimal valor;
	
	
	/**
	 * Data que o lançamento foi gerado.
	 */
	@OrderBy
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_lancamento", nullable = false)
	private Date dataLancamento;

	// TODO: Pelo o que eu entendi, é a mesma coisa que data lançamento. Ver
	// qual dos dois fica. Inclusive ele combina é com o o documento.
	@Temporal(TemporalType.DATE)
	@Column(name = "data_emissao", nullable = true)
	private Date dataEmissao;

	// TODO: Ver se vai chamar vencimento ou compensação. Talvez compensação
	// seja melhor.
	@Temporal(TemporalType.DATE)
	@Column(name = "data_vencimento", nullable = true)
	private Date dataVencimento;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_competencia", nullable = true)
	private Date dataCompetencia;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_pagamento", nullable = true)
	private Date dataPagamento;
	
	@Column(name = "numero_parcela", length = 3)
	private int numeroParcela;

	private String historico;

	// Pessoa a quem vou pagar ou quem vai receber;
	@ManyToOne
	private Pessoa pessoa;

	@ManyToOne(optional = true)
	@JoinColumn(name = "forma_de_pagamento_id", referencedColumnName = "id")
	private DominioValor formaDePagamento;

	@ManyToOne(optional = true)
	@JoinColumn(name = "documento_id", referencedColumnName = "id")
	private DominioValor documento;

	@ManyToOne(optional = false)
	@JoinColumn(name = "conta_id", referencedColumnName = "id")
	private Conta conta;

	@ManyToOne(optional = true)
	@JoinColumn(name = "principal_id", referencedColumnName = "id")
	private Lancamento principal;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "principal")
	@OrderBy("dataLancamento ASC")
	private List<Lancamento> parcelas;

	@ManyToOne(optional = true)
	@JoinColumn(name = "plano_de_contas_id", referencedColumnName = "id")
	private PlanoDeContas planoDeContas;

	@ManyToOne(optional = true)
	@JoinColumn(name = "centro_de_custos", referencedColumnName = "id")
	private CentroDeCustos centroDeCustos;
	
	
	public Lancamento() {
		setDataLancamento(DataHelper.hoje());
		parcelas = new ArrayList<Lancamento>();
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LancamentoType getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(LancamentoType tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public int getMesRef() {
		return mesRef;
	}

	public void setMesRef(int mesRef) {
		this.mesRef = mesRef;
	}

	public int getAnoRef() {
		return anoRef;
	}

	public void setAnoRef(int anoRef) {
		this.anoRef = anoRef;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public DominioValor getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(DominioValor formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public DominioValor getDocumento() {
		return documento;
	}

	public void setDocumento(DominioValor documento) {
		this.documento = documento;
	}

	public PlanoDeContas getPlanoDeContas() {
		return planoDeContas;
	}

	public void setPlanoDeContas(PlanoDeContas planoDeContas) {
		this.planoDeContas = planoDeContas;
	}

	public CentroDeCustos getCentroDeCustos() {
		return centroDeCustos;
	}

	public void setCentroDeCustos(CentroDeCustos centroDeCustos) {
		this.centroDeCustos = centroDeCustos;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Date getDataCompetencia() {
		return dataCompetencia;
	}

	public void setDataCompetencia(Date dataCompetencia) {
		this.dataCompetencia = dataCompetencia;
	}

	public LancamentoSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(LancamentoSituacao situacao) {
		this.situacao = situacao;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(int numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public Lancamento getPrincipal() {
		return principal;
	}

	public void setPrincipal(Lancamento principal) {
		this.principal = principal;
	}

	public List<Lancamento> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Lancamento> parcelas) {
		this.parcelas = parcelas;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
