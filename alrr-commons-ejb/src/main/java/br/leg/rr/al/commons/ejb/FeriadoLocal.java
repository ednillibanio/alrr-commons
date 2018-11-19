/*******************************************************************************
 * Copyright (c) 2017, KMDR Consultoria e Serviços, Boa Vista, RR - Brasil.
 * Todos os direitos reservados. Este programa é propriedade da Assembleia Legislativa do Estado de Roraima e não é permitida a distribuição, alteração ou cópia da mesma sem prévia autoriazação.
 ******************************************************************************/
package br.leg.rr.al.commons.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import br.leg.rr.al.commons.domain.FeriadoType;
import br.leg.rr.al.commons.jpa.Feriado;
import br.leg.rr.al.core.dao.DominioDaoStatus;
import br.leg.rr.al.core.domain.Mes;

/**
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a><br/>
 *         Data Criação: 27-08-2012<br/>
 * @since 1.0.0
 */
@Local
public interface FeriadoLocal extends DominioDaoStatus<Feriado> {

	/**
	 * Busca entidade {@code Feriado} pelo campo "mes".<br>
	 * 
	 * @value {@literal List<Mes>};
	 */
	String PESQUISAR_PARAM_MESES = "meses";

	/**
	 * Busca entidade {@code Feriado} pelo campo "tipo".<br>
	 * 
	 * @value {@literal List<FeriadoType>};
	 */
	String PESQUISAR_PARAM_TIPOS = "tipos";

	/**
	 * Busca os feriados de acordo com os parametros informados.
	 * 
	 * @param feriado
	 *            objeto a ser buscado.
	 * @param tipos
	 *            tipos de feriados.
	 * @param meses
	 *            meses dos feriados.
	 * @return Lista de feriados. Retorna nulo caso nenhum feriado encontrado.
	 */
	@Deprecated
	public List<Feriado> pesquisar(Feriado feriado, List<FeriadoType> tipos, List<Mes> meses);

	/**
	 * Busca todos os feriados estaduais, municipais e nacionais, conforme o
	 * intervalo informado nos parametros <code>inicio</code> e <code>fim</code>.
	 * 
	 * @param inicio
	 *            Data inicio dos feriados.
	 * @param fim
	 *            Data fim dos feriados.
	 * @return Lista de feriados que satisfaçam a condição do intervalo. Retorna
	 *         <code>null</code> caso nenhum feriado seja encontrado.
	 */
	public List<Feriado> buscarPorIntervalo(Date inicio, Date fim);

}
