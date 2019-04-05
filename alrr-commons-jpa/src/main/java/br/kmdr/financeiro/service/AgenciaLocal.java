package br.kmdr.financeiro.service;

import javax.ejb.Local;

import br.kmdr.core.dao.JPADao;
import br.kmdr.financeiro.entity.Agencia;

@Local
public interface AgenciaLocal extends JPADao<Agencia, Integer> {

	/**
	 * Busca a agencia pelo numero da agência e o id do banco.
	 * 
	 * @param bancoId
	 *            Id da entidade banco. Não é o codigo do banco.
	 * @param numero
	 *            numeroAgencia da entidade agencia que pertence aquele banco.
	 * @return retorna a agencia caso exista. Caso contrário, retorna null.
	 */
	public Agencia findByNumero(Long bancoId, String numero);
}
