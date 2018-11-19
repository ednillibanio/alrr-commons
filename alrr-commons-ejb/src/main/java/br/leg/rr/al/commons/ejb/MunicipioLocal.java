package br.leg.rr.al.commons.ejb;

import java.util.List;

import javax.ejb.Local;

import br.leg.rr.al.commons.domain.UfType;
import br.leg.rr.al.commons.jpa.Municipio;
import br.leg.rr.al.core.dao.BeanException;
import br.leg.rr.al.core.dao.JPADaoStatus;

@Local
public interface MunicipioLocal extends JPADaoStatus<Municipio, Integer> {

	/**
	 * Busca entidade {@code Municipio} pelo campo "nome".<br>
	 * 
	 * @value {@literal String};
	 */
	String PESQUISAR_PARAM_NOME = "nome";

	/**
	 * Busca pelo campo "uf" da entidade {@code Municipio}.<br>
	 * 
	 * @value {@literal List<UfType>};
	 */
	String PESQUISAR_PARAM_UFS = "ufs";

	/**
	 * Busca as localidades que contém parte do nome informado.
	 * 
	 * @param nome
	 *            nome da municipio a ser pesquisada.
	 * @return retorna uma lista de nomes que satisfaz o <param>nome</param>
	 *         informado.
	 * @throws ControllerException
	 */
	@Override
	public List<Municipio> buscarPorNome(String nome) throws BeanException;

	/**
	 * Busca Municipio por Unidade Federativa.
	 * 
	 * @param uf
	 *            nome da uf usada na busca da municipio.
	 * @param nome
	 *            nome da municipio que deve ser pesquisada junto com a uf
	 *            informada.
	 * @return municipio que satisfaz a condição de busca, informada pelos
	 *         parametros do método.
	 * @throws ControllerException
	 */
	public Municipio buscarPorUf(UfType uf, String nome) throws BeanException;

	/**
	 * 
	 */
	void importarMunicipiosDoIBGE();

	/**
	 * @param nome
	 * @param uf
	 * @return
	 * @throws BeanException
	 */
	List<Municipio> buscarPorNome(String nome, UfType uf) throws BeanException;

}
