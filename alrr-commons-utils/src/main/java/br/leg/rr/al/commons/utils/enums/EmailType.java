package br.leg.rr.al.commons.utils.enums;

import java.util.EnumMap;

import br.leg.rr.al.core.utils.BaseEnum;

/**
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com">Ednil Libanio da Costa Junior</a>
 *
 */
public enum EmailType implements BaseEnum<EmailType> {

	DANFE("DANFE"), LOJA_VIRTUAL("Loja Virtual"), COBRANCA("Cobrança"), PESSOAL("Pessoal");

	private EmailType(String label) {
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
	@Override
	public EnumMap<EmailType, String> getEnumMap() {
		EnumMap<EmailType, String> map = new EnumMap<EmailType, String>(EmailType.class);
		map.put(EmailType.PESSOAL, "1");
		map.put(EmailType.COBRANCA, "2");
		map.put(EmailType.LOJA_VIRTUAL, "3");
		map.put(EmailType.DANFE, "4");
		return map;
	}

}
