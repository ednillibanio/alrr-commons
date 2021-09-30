package br.leg.rr.al.commons.utils.enums;

/**
 * Tipos de Ordenacao
 *
 * @author <a href="mailto:ednil.libanio@gmail.com">Ednil Libanio da Costa
 *         Junior</a>
 * @version $Revision: 1.0 $
 */
public enum OrdenacaoType {

	C("Cronológica"), V("Valor"), P("Preferência");

	private String descricao;

	private OrdenacaoType(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
