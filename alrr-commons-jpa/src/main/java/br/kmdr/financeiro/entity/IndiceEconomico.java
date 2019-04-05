package br.kmdr.financeiro.entity;

import br.kmdr.core.entity.BaseEntity;

public class IndiceEconomico extends  BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 994153222409239904L;

	private Long id;

	// nome do indice: IGPM-FGV, IPCA
	private String indice;

	private String periodo;

	private float valor;

}
