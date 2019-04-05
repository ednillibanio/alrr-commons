package br.kmdr.financeiro.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.kmdr.core.entity.BaseEntity;

@Entity
@Table
public class Moeda extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4906178922589081500L;

	@Column(name = "sigla", nullable = false)
	private String sigla;

	@Column(name = "nome_singular", nullable = false)
	private String nomeSingular;

	@Column(name = "nome_plural", nullable = false)
	private String nomePlural;

	@Column(name = "cotacao", nullable = true)
	private float cotacao;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cotacao", nullable = true)
	private Date dataCotacao;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNomeSingular() {
		return nomeSingular;
	}

	public void setNomeSingular(String nomeSingular) {
		this.nomeSingular = nomeSingular;
	}

	public String getNomePlural() {
		return nomePlural;
	}

	public void setNomePlural(String nomePlural) {
		this.nomePlural = nomePlural;
	}

	public float getCotacao() {
		return cotacao;
	}

	public void setCotacao(float cotacao) {
		this.cotacao = cotacao;
	}

	public Date getDataCotacao() {
		return dataCotacao;
	}

	public void setDataCotacao(Date dataCotacao) {
		this.dataCotacao = dataCotacao;
	}
}
