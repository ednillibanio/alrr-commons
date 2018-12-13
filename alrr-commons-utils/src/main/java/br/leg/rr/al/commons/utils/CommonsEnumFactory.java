package br.leg.rr.al.commons.utils;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.leg.rr.al.commons.domain.FeriadoType;
import br.leg.rr.al.core.domain.DiaSemana;
import br.leg.rr.al.core.domain.EmailType;
import br.leg.rr.al.core.domain.Mes;
import br.leg.rr.al.core.domain.SistemaLocale;
import br.leg.rr.al.core.domain.StatusType;
import br.leg.rr.al.core.domain.TurnoType;

/**
 * @author Ednil Libanio da Costa Junior
 * @date 19-04-2012
 */
@Named
@RequestScoped
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

	public StatusType[] getStatusType() {
		return StatusType.values();
	}

	public SistemaLocale[] getIdiomas() {
		return SistemaLocale.values();
	}
}
