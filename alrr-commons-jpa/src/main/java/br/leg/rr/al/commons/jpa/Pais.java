/*******************************************************************************
 * Copyright (c) 2017, KMDR Consultoria e Serviços, Boa Vista, RR - Brasil.
 * Todos os direitos reservados. Este programa é propriedade da Assembleia Legislativa do Estado de Roraima e não é permitida a distribuição, alteração ou cópia da mesma sem prévia autoriazação.
 ******************************************************************************/
package br.leg.rr.al.commons.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.leg.rr.al.core.jpa.BaseEntityStatus;

/**
 * Classe persistente que representa a tabela "pais".
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a>
 * @since 1.0.0
 */
@Entity
@Table
public class Pais extends BaseEntityStatus<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1338795676941062754L;

	@Column(nullable = false, length = 250)
	private String nome;

	@Column(length = 3, nullable = true)
	private String sigla;

	@Column(name = "codigo_discagem", length = 4, nullable = true)
	private String codigoDiscagem;

	@Column(length = 70, nullable = true)
	private String nacionalidade;

	@Column(nullable = true)
	private Boolean ativo = Boolean.FALSE;

	public String getCodigoDiscagem() {
		return this.codigoDiscagem;
	}

	public String getNacionalidade() {
		return this.nacionalidade;
	}

	public Object getNome() {
		return this.nome;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setCodigoDiscagem(String codigoDiscagem) {
		this.codigoDiscagem = codigoDiscagem;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
