package br.kmdr.imobil.entity.imovel;

import br.kmdr.util.entity.BaseEntity;

public class Comissao extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 75256262155846126L;
	private Long id;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
