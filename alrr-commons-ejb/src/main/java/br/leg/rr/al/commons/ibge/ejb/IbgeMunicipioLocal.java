/*******************************************************************************
 * ALE-RR Licença
 * Copyright (C) 2018, ALE-RR
 * Boa Vista, RR - Brasil
 * Todos os direitos reservados.
 * 
 * Este programa é propriedade da Assembleia Legislativa do Estado de Roraima e 
 * não é permitida a distribuição, alteração ou cópia da mesma sem prévia autoriazação.
 ******************************************************************************/
package br.leg.rr.al.commons.ibge.ejb;

import java.util.List;

import javax.ejb.Local;

import br.leg.rr.al.commons.domain.UfType;
import br.leg.rr.al.commons.ibge.jpa.IbgeMunicipio;
import br.leg.rr.al.core.dao.JPADao;

/**
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a>
 * @since 1.0.0
 */
@Local
public interface IbgeMunicipioLocal extends JPADao<IbgeMunicipio, Integer> {

	static final String URL_IBGE_MUNICIPIOS = "https://servicodados.ibge.gov.br/api/v1/localidades/municipios";

	static final String URL_IBGE_MUNICIPIOS_POR_UFS = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/";

	/**
	 * @param uf
	 * @return
	 */
	List<IbgeMunicipio> buscarMunicipiosPorUF(UfType uf);

	/**
	 * 
	 * @return
	 */
	List<IbgeMunicipio> buscarMunicipios();

}
