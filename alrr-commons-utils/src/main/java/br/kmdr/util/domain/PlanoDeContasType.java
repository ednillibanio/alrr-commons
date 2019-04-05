package br.kmdr.util.domain;

public enum PlanoDeContasType {

	ATIVO(1, "enum.plano.contas.ativo"), PASSIVO(2, "enum.plano.contas.passivo"), RECEITA(
			3, "enum.plano.contas.receita"), DESPESA(4,
			"enum.plano.contas.despesa");

	private String label;
	private int valor;

	private PlanoDeContasType(int valor, String label) {
		this.valor = valor;
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public String getValor() {
		return label;
	}

	@Override
	public String toString() {
		return String.valueOf(valor);

	}
}
