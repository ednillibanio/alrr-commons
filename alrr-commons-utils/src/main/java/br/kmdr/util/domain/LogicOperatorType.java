package br.kmdr.util.domain;

public enum LogicOperatorType {

	ANY("Qualquer"), ALL("Todos");

	private LogicOperatorType(String label) {
		this.label = label;
	}

	private String label;

	public String getLabel() {
		return label;
	}

	@Override
	public String toString() {
		return getLabel();
	}
}
