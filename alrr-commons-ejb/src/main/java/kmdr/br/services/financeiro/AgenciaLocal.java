package br.kmdr.imobil.service.financeiro;

import javax.ejb.Local;

import br.kmdr.imobil.entity.financeiro.Agencia;
import br.kmdr.util.dao.Dao;

@Local
public interface AgenciaLocal extends Dao<Agencia> {

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
