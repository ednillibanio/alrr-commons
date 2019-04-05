package br.leg.rr.al.commons.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import br.leg.rr.al.commons.jpa.Feriado;
import br.leg.rr.al.core.dao.DominioJPADao;

@Local
public interface FeriadoLocal extends DominioJPADao<Feriado> {

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
	 * Busca todos os feriados estaduais, municipais e nacionais, conforme o
	 * intervalo informado nos parametros <code>inicio</code> e <code>fim</code>.
	 * 
	 * @param inicio Data inicio dos feriados.
	 * @param fim    Data fim dos feriados.
	 * @return Lista de feriados que satisfaçam a condição do intervalo. Retorna
	 *         <code>null</code> caso nenhum feriado seja encontrado.
	 */
	public List<Feriado> buscarPorIntervalo(Date inicio, Date fim);

}
