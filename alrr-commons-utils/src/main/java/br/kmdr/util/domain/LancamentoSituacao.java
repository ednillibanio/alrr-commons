package br.kmdr.util.domain;

public enum LancamentoSituacao {
	A_RECEBER(1, "enum.lancamento.situacao.areceber"), RECEBIDO(2,
			"enum.lancamento.situacao.recebido"), A_PAGAR(3,
			"enum.lancamento.situacao.apagar"), PAGO(4,
			"enum.lancamento.situacao.pago");

	private String label;
	private int valor;

	private LancamentoSituacao(int valor, String label) {
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
