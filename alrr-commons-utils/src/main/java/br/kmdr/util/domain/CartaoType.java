package br.kmdr.util.domain;

import br.kmdr.util.entity.BasicEnumType;

public enum CartaoType implements BasicEnumType {

	CREDITO("0", "enum.cartao.credito"),

	DEBITO("1", "enum.cartao.debito"),

	BENEFICIO("2", "enum.cartao.beneficio"),

	DEBITO_CREDITO("3", "enum.cartao.debito.credito");

	private CartaoType(String value, String label) {
		this.label = label;
		this.value = value;
	}

	private String label;
	private String value;

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return label;
	}

}
