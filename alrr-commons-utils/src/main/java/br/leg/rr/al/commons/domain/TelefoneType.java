package br.leg.rr.al.commons.domain;

import java.util.EnumMap;

import br.leg.rr.al.core.jpa.BasicEnum;

/**
 * @author Ednil Libanio da Costa Junior
 * @date 05-01-2012
 */
public enum TelefoneType implements BasicEnum<TelefoneType> {

	/**
	 * Valor banco de dados = 1
	 */
	RESIDENCIAL("Residencial"),
	/**
	 * Valor banco de dados = 2
	 */
	COMERCIAL("Comercial"), // Valor
	/**
	 * Valor banco de dados = 3
	 */
	CELULAR("Celular"),
	/**
	 * Valor banco de dados = 4
	 */
	FIXO("Fixo"),
	/**
	 * Valor banco de dados = 5
	 */
	FAX("Fax"),
	/**
	 * Valor banco de dados = 6
	 */
	SETOR("Setor");

	private TelefoneType(String label) {
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

	/**
	 * Contém os valores das chaves que serão armazenados no banco de dados.
	 * 
	 * @return Retorna uma lista com todos os TelefoneType.
	 */
	public EnumMap<TelefoneType, String> getEnumMap() {
		EnumMap<TelefoneType, String> map = new EnumMap<TelefoneType, String>(TelefoneType.class);
		map.put(TelefoneType.RESIDENCIAL, "1");
		map.put(TelefoneType.COMERCIAL, "2");
		map.put(TelefoneType.CELULAR, "3");
		map.put(TelefoneType.FIXO, "4");
		map.put(TelefoneType.FAX, "5");
		map.put(TelefoneType.SETOR, "6");
		return map;
	}

}
