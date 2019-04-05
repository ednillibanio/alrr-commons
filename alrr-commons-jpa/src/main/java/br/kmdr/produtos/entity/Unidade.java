package br.kmdr.produtos.entity;

import javax.persistence.Entity;

import br.kmdr.core.entity.DominioEntity;

@Entity
public class Unidade extends DominioEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2882439202262900921L;

	private String sigla;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
