package br.kmdr.financeiro.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.kmdr.core.entity.BaseEntity;

/**
 * The persistent class for the banco database table.
 * 
 */
@Entity
@Table
public class Banco extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8421420645263950206L;

	@OneToMany(mappedBy = "banco", fetch = FetchType.LAZY)
	private List<Agencia> agencias;

	@Column(nullable = true, length = 5, unique = true)
	private String codigo;

	@Column(nullable = false, unique = false)
	private String nome;

	@Column(nullable = true, length = 250)
	private String site;

	public Banco() {
	}

	public List<Agencia> getAgencias() {
		return this.agencias;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setAgencias(List<Agencia> agencias) {
		this.agencias = agencias;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

}