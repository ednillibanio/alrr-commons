package br.leg.rr.al.commons.domain;

import java.util.EnumMap;

import br.leg.rr.al.core.jpa.BasicEnum;

public enum FuncionalidadeType implements BasicEnum<FuncionalidadeType> {

	TELA("Tela"), BOTAO("Botão");

	private FuncionalidadeType(String label) {
		this.label = label;

	}

	private String label;

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public String toString() {
		return label;
	}

	@Override
	public EnumMap<FuncionalidadeType, ?> getEnumMap() {
		EnumMap<FuncionalidadeType, String> map = new EnumMap<FuncionalidadeType, String>(FuncionalidadeType.class);
		map.put(FuncionalidadeType.TELA, "T");
		map.put(FuncionalidadeType.BOTAO, "B");
		return map;
	}

}
