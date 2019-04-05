package br.kmdr.financeiro.service;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.kmdr.core.dao.JPABaseDao;
import br.kmdr.financeiro.entity.ContaBancaria;

@Named
@Stateless
public class ContaBancariaBean extends JPABaseDao<ContaBancaria, Integer> implements ContaBancariaLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8752928639382404303L;

}
