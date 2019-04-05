package br.kmdr.imobil.service.financeiro;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.kmdr.imobil.entity.financeiro.CartaoDeCredito;
import br.kmdr.imobil.entity.financeiro.Conta;
import br.kmdr.imobil.entity.financeiro.ContaBancaria;
import br.kmdr.util.dao.BaseDao;

@Named
@Stateless
public class ContaBean extends BaseDao<Conta> implements ContaLocal {

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
