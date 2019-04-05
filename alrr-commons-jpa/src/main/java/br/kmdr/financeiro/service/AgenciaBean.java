package br.kmdr.financeiro.service;

import java.util.Hashtable;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.kmdr.core.dao.JPABaseDao;
import br.kmdr.financeiro.entity.Agencia;

@Named
@Stateless
public class AgenciaBean extends JPABaseDao<Agencia, Integer> implements AgenciaLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -631186735826008885L;

	@Override
	public Agencia findByNumero(Long bancoId, String numero) {
		Map<String, Object> params = new Hashtable<String, Object>(2);
		params.put("banco_id", bancoId);
		params.put("numero", numero);

		return findEntity("Agencia.findByNumero", params);
	}

}
