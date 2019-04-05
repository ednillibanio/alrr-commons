package br.kmdr.util.domain;

import br.kmdr.util.entity.BasicEnumType;

public enum ContaMovimentacaoStatus implements BasicEnumType {

	ABERTA("A", "enum.conta.status.aberta"), ENCERRADA("E",
			"enum.conta.status.encerrada");

	private ContaMovimentacaoStatus(String value, String label) {
		this.value = value;
		this.label = label;
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

}
