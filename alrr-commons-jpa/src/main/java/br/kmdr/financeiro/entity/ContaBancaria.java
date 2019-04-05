package br.kmdr.financeiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "conta_bancaria")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class ContaBancaria extends Conta {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6964437138223541101L;

	@Column(nullable = true, length = 8)
	private String numero;

	@Column(nullable = true, length = 3)
	private String dv;

	@Column(name = "nome_gerente", nullable = true)
	private String nomeGerente;

	@Column(nullable = false, length = 11, name = "celular")
	private String celularGerente;

	@ManyToOne
	private Agencia agencia;

	public ContaBancaria() {
		agencia = new Agencia();
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDv() {
		return dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
	}

	public String getNomeGerente() {
		return nomeGerente;
	}

	public void setNomeGerente(String nomeGerente) {
		this.nomeGerente = nomeGerente;
	}

	public String getCelularGerente() {
		return celularGerente;
	}

	public void setCelularGerente(String celularGerente) {
		this.celularGerente = celularGerente;
	}

}
