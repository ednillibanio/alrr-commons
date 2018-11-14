package br.leg.rr.al.commons.domain;

import java.util.EnumMap;

import br.leg.rr.al.core.jpa.BasicEnum;

public enum FeriadoType implements BasicEnum<FeriadoType> {

	MUNICIPAL("Municipal"), ESTADUAL("Estadual"), NACIONAL("Nacional");

	private FeriadoType(String label) {
		this.label = label;
	}

	private String label;

	/**
	 * 
	 */
	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public String toString() {
		return label;
	}

	/**
	 * Contém os valores das chaves que serão armazenados no banco de dados.
	 * 
	 * @return Retorna uma lista com todos os FeriadoType.
	 */
	public EnumMap<FeriadoType, String> getEnumMap() {
		EnumMap<FeriadoType, String> map = new EnumMap<FeriadoType, String>(FeriadoType.class);
		map.put(FeriadoType.NACIONAL, "1");
		map.put(FeriadoType.ESTADUAL, "2");
		map.put(FeriadoType.MUNICIPAL, "3");
		return map;
	}

}
