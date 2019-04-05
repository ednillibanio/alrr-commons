package br.kmdr.imobil.service.financeiro;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.kmdr.imobil.entity.financeiro.ContaBancaria;
import br.kmdr.util.dao.BaseDao;

@Named
@Stateless
public class ContaBancariaBean extends BaseDao<ContaBancaria> implements
		ContaBancariaLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8752928639382404303L;
	

}
