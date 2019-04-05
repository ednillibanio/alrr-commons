package br.kmdr.util.domain;

import br.kmdr.util.entity.BasicEnumType;

public enum EstadoCivilType implements BasicEnumType {

	SOLTEIRO("1", "enum.estado.civil.solteiro"), CASADO("2",
			"enum.estado.civil.casado"), DIVORCIADO("3",
			"enum.estado.civil.divorciado"), SEPARADO("4",
			"enum.estado.civil.separado"), VIUVO("5", "enum.estado.civil.viuvo");

	private EstadoCivilType(String value, String label) {
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
