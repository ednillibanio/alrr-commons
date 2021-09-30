package br.leg.rr.al.commons.utils.enums;

import java.util.EnumMap;

import br.leg.rr.al.core.utils.BaseEnum;

/**
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com">Ednil Libanio da Costa Junior</a>
 *
 */
public enum TurnoType implements BaseEnum<TurnoType> {

	MATUTINO("Matutino"), VESPERTINO("Vespertino"), NOTURNO("Noturno");

	private TurnoType(String label) {
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
	public EnumMap<TurnoType, ?> getEnumMap() {
		EnumMap<TurnoType, String> map = new EnumMap<TurnoType, String>(TurnoType.class);
		map.put(TurnoType.MATUTINO, "M");
		map.put(TurnoType.VESPERTINO, "V");
		map.put(TurnoType.NOTURNO, "N");
		return map;
	}
}
