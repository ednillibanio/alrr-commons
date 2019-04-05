package br.kmdr.imobil.service.financeiro;

import java.util.List;

import javax.ejb.Local;

import br.kmdr.imobil.entity.financeiro.CartaoDeCredito;
import br.kmdr.imobil.entity.financeiro.Conta;
import br.kmdr.imobil.entity.financeiro.ContaBancaria;
import br.kmdr.util.dao.Dao;

@Local
public interface ContaLocal extends Dao<Conta> {

	public List<ContaBancaria> getContaBancaria();

	public List<CartaoDeCredito> getCartaoDeCredito();

	public List<CartaoDeCredito> getCobrancaBancaria();
}
