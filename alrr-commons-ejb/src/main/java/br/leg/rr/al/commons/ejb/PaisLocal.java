/*******************************************************************************
 * Copyright (c) 2017, KMDR Consultoria e Serviços, Boa Vista, RR - Brasil.
 * Todos os direitos reservados. Este programa é propriedade da Assembleia Legislativa do Estado de Roraima e não é permitida a distribuição, alteração ou cópia da mesma sem prévia autoriazação.
 ******************************************************************************/
package br.leg.rr.al.commons.ejb;

import java.util.List;

import javax.ejb.Local;

import br.leg.rr.al.commons.jpa.Pais;
import br.leg.rr.al.core.dao.JPADaoStatus;

@Local
public interface PaisLocal extends JPADaoStatus<Pais, Integer> {

	@Override
	public List<Pais> buscarPorNome(String nome);

}
