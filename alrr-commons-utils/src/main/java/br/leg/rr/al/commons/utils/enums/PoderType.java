package br.leg.rr.al.commons.utils.enums;

import java.util.EnumMap;

import br.leg.rr.al.core.utils.BaseEnum;

/**
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com">Ednil Libanio da Costa
 *         Junior</a>
 *
 */
public enum PoderType implements BaseEnum<PoderType> {

	EXECUTIVO("Executivo"), LEGISLATIVO("Legislativo"), JUDICIARIO("Judiciario");

	private String label;

	private PoderType(String label) {
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

	public EnumMap<PoderType, String> getEnumMap() {
		EnumMap<PoderType, String> map = new EnumMap<PoderType, String>(PoderType.class);
		map.put(PoderType.EXECUTIVO, "1");
		map.put(PoderType.JUDICIARIO, "2");
		map.put(PoderType.LEGISLATIVO, "3");
		return map;
	}

}
