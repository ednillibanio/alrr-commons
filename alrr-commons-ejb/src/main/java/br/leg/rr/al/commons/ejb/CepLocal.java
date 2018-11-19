package br.leg.rr.al.commons.ejb;

import javax.ejb.Local;

import br.leg.rr.al.commons.jpa.Cep;
import br.leg.rr.al.core.dao.JPADaoStatus;

/**
 * @author Ednil Libanio da Costa Junior
 * @date 09-04-2017
 */
@Local
public interface CepLocal extends JPADaoStatus<Cep, Long> {

	/**
	 * <p>
	 * Método que busca o cep tanto nos correios quanto na base local. Primeiramente
	 * busca o cep na base local. Caso não o encontre, irá pesquisar via web
	 * service. <br>
	 * Toda consulta web service que o cep informado for encontrado, será salvo na
	 * base de dados local. Incluindo as Localidades e Bairros.
	 * </p>
	 * 
	 * @see #buscarCepBaseLocal(String)
	 * @see #buscarCepWS(String)
	 * @param cep
	 * @return retorna o endereço ou nulo caso não encontre.
	 */
	public Cep buscarCep(String cep);

	/**
	 * Método que busca o cep na base de dados local.
	 * 
	 * @param cep
	 *            valor a ser consultado. O valor poderá ser formatado. Será tratado
	 *            dentro do método.
	 * @return Cep encontrado na base de dados local. Caso contrário,
	 *         <code>null</coce>.
	 */
	public Cep buscarCepBaseLocal(String cep);

	/**
	 * Método que busca o cep via web service.
	 * 
	 * @param cep
	 *            valor a ser consultado. O valor poderá ser formatado. Será tratado
	 *            dentro do método.
	 * @return Cep encontrado na base de dados local. Caso contrário,
	 *         <code>null</coce>.
	 */
	public Cep buscarCepWS(String cep);
}
