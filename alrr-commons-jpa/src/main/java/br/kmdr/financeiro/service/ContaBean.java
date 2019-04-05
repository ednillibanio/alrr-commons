package br.kmdr.financeiro.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.kmdr.core.dao.JPABaseDao;
import br.kmdr.financeiro.entity.CartaoDeCredito;
import br.kmdr.financeiro.entity.Conta;
import br.kmdr.financeiro.entity.ContaBancaria;

@Named
@Stateless
public class ContaBean extends JPABaseDao<Conta,Integer> implements ContaLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4845707332132410053L;

	@Override
	public List<ContaBancaria> getContaBancaria() {
		return null;
	}

	@Override
	public List<CartaoDeCredito> getCartaoDeCredito() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartaoDeCredito> getCobrancaBancaria() {
		// TODO Auto-generated method stub
		return null;
	}

}
