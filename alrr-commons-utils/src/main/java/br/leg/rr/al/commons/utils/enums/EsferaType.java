package br.leg.rr.al.commons.utils.enums;

import java.util.EnumMap;

import br.leg.rr.al.core.utils.BaseEnum;

/**
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com">Ednil Libanio da Costa
 *         Junior</a>
 *
 */
public enum EsferaType implements BaseEnum<EsferaType> {

	FEDERAL("Federal"), MUNICIPAL("Municipal"), ESTADUAL("Estadual");

	private String label;

	private EsferaType(String label) {
		this.label = label;
	}

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

	public EnumMap<EsferaType, String> getEnumMap() {
		EnumMap<EsferaType, String> map = new EnumMap<EsferaType, String>(EsferaType.class);
		map.put(EsferaType.FEDERAL, "1");
		map.put(EsferaType.ESTADUAL, "2");
		map.put(EsferaType.MUNICIPAL, "3");
		return map;
	}

}
