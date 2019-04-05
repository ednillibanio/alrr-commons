package br.kmdr.financeiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.kmdr.commons.entity.Localidade;
import br.kmdr.core.entity.BaseEntity;

/**
 * The persistent class for the agencia database table.
 * 
 */
@Entity
@Table
public class Agencia extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4059312271299573462L;

	@Column(length = 150, nullable = true)
	private String nome;

	@Column(name = "numero_agencia", nullable = false, length = 5)
	private String numeroAgencia;

	@Column(length = 11, nullable = true)
	private String telefone;

	// bi-directional many-to-one association to Banco
	@ManyToOne
	@JoinColumn(name = "banco_id", nullable = false)
	private Banco banco;

	// bi-directional many-to-one association to Localidade
	@ManyToOne
	@JoinColumn(name = "localidade_id", nullable = true)
	private Localidade localidade;

	public Agencia() {
		banco = new Banco();
		localidade = new Localidade();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

}