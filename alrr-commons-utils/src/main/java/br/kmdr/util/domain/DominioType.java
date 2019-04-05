package br.kmdr.util.domain;

public enum DominioType {

	ESCOLARIDADE("Escolaridade"), RENDA_MENSAL("Renda Mensal"), QTDE_FUNCIONARIOS(
			"Quantidade de Funcionários"), FATURAMENTO_MENSAL(
			"Faturamento Mensal");

	DominioType( String label) {
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
