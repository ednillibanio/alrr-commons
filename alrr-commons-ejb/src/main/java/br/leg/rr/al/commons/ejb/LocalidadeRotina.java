/*******************************************************************************
 * ALE-RR Licença
 * Copyright (C) 2018, ALE-RR
 * Boa Vista, RR - Brasil
 * Todos os direitos reservados.
 * 
 * Este programa é propriedade da Assembleia Legislativa do Estado de Roraima e 
 * não é permitida a distribuição, alteração ou cópia da mesma sem prévia autoriazação.
 ******************************************************************************/
package br.leg.rr.al.commons.ejb;

import javax.ejb.EJB;

/**
 * @author Ednil Libanio da Costa Junior
 * @date 10-04-2018
 */

// @Startup
// @Singleton
public class LocalidadeRotina {

	@EJB
	private MunicipioLocal bean;

	// @PostConstruct
	public void init() {
		bean.importarMunicipiosDoIBGE();
	}
}
