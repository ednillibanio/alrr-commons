package br.leg.rr.al.commons.ejb;

import java.util.List;

import javax.ejb.Local;

import br.leg.rr.al.commons.jpa.Bairro;
import br.leg.rr.al.core.dao.BeanException;
import br.leg.rr.al.core.dao.JPADaoStatus;

@Local
public interface BairroLocal extends JPADaoStatus<Bairro, Integer> {

	/**
	 * Busca os bairros que contém parte do nome informado.
	 * 
	 * @param nome
	 *            nome do bairro a ser pesquisado.
	 * @return lista de nomes que satisfazem o <param>nome</param> informado.
	 * @throws ControllerException
	 */
	@Override
	public List<Bairro> buscarPorNome(String nome) throws BeanException;

	/**
	 * Busca o Bairro pelo id da entidade municipio, e pelo nome do bairro.
	 * 
	 * @param locId
	 *            id da entidade municipio.
	 * @param nome
	 *            nome do bairro.
	 * @return bairro encontrado de acordo com os valores informados nos
	 *         parametros.
	 * @throws ControllerException
	 */
	public Bairro buscarPorLocalidadeId(Integer locId, String nome) throws BeanException;

}
