package br.kmdr.commons.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.kmdr.util.entity.BaseEntity;

@Entity
@Table
public class Dominio extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1120079989287648706L;


	@Column(nullable = false, unique = true, length = 100)
	private String nome;

	@Column(length = 250)
	private String descricao;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "dominio_id", nullable = false)
	private List<DominioValor> dominiosValores;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<DominioValor> getDominiosValores() {
		return dominiosValores;
	}

	public void setDominiosValores(List<DominioValor> dominiosValores) {
		this.dominiosValores = dominiosValores;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
