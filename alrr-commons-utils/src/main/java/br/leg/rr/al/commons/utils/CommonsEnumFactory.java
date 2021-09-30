package br.leg.rr.al.commons.utils;

import br.leg.rr.al.commons.utils.enums.DiaSemana;
import br.leg.rr.al.commons.utils.enums.EmailType;
import br.leg.rr.al.commons.utils.enums.FeriadoType;
import br.leg.rr.al.commons.utils.enums.Mes;
import br.leg.rr.al.commons.utils.enums.TelefoneType;
import br.leg.rr.al.commons.utils.enums.TurnoType;

/**
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com">Ednil Libanio da Costa
 *         Junior</a>
 *
 */
public class CommonsEnumFactory {

	public FeriadoType[] getTiposFeriados() {
		return FeriadoType.values();
	}

	public DiaSemana[] getDiasSemana() {
		return DiaSemana.values();
	}

	public EmailType[] getEmailTypes() {
		return EmailType.values();
	}

	public Mes[] getMeses() {
		return Mes.values();
	}

	public TurnoType[] getTurnoTypes() {
		return TurnoType.values();
	}

	public TelefoneType[] getTelefoneType() {
		return TelefoneType.values();
	}
}
