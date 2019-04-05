package br.kmdr.financeiro.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cobranca_bancaria")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class CobrancaBancaria extends Conta {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2764721750279594493L;

	// informar nome do cedente diferente da Empresa. Marca quando deseja
	// informar outro nome em vez da empresa que comprou o sistema
	private Boolean cedente;
	private String carteira; // ????
	private String variacaoCarteira; // ???

	@OneToOne(fetch = FetchType.LAZY)
	private Boleto boleto;

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}
}
