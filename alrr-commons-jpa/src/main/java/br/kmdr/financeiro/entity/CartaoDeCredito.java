package br.kmdr.financeiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

@Entity
@Table(name = "cartao_credito")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class CartaoDeCredito extends Conta {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3231993062117636966L;

	@Digits(integer = 2, fraction = 0)
	@Column(name = "dia_fechamento", nullable = true, length = 2)
	private short diaFechamento;

	@Digits(integer = 2, fraction = 0)
	@Column(name = "dia_vencimento", nullable = true, length = 2)
	private short diaVencimento;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "conta_pagamento_id", nullable = true)
	private Conta contaPagamento;

	// TODO: Definir a operadora pois não é só banco operadora. Acho que tem que
	// cadastrar operadora.
	@ManyToOne(optional = false)
	@JoinColumn(name = "operadora_cartao_id", nullable = false)
	private Banco operadora;

	@ManyToOne(optional = false)
	@JoinColumn(name = "bandeira_cartao_id", nullable = false)
	private BandeiraCartao bandeira;

	public int getDiaFechamento() {
		return diaFechamento;
	}

	public void setDiaFechamento(short diaFechamento) {
		this.diaFechamento = diaFechamento;
	}

	public int getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(short diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public Conta getContaPagamento() {
		return contaPagamento;
	}

	public void setContaPagamento(Conta contaPagamento) {
		this.contaPagamento = contaPagamento;
	}

	public BandeiraCartao getBandeira() {
		return bandeira;
	}

	public void setBandeira(BandeiraCartao bandeira) {
		this.bandeira = bandeira;
	}
}
