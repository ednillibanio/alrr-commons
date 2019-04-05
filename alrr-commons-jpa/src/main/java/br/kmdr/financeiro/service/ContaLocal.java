package br.kmdr.financeiro.service;

import java.util.List;

import javax.ejb.Local;

import br.kmdr.core.dao.JPADao;
import br.kmdr.financeiro.entity.CartaoDeCredito;
import br.kmdr.financeiro.entity.Conta;
import br.kmdr.financeiro.entity.ContaBancaria;

@Local
public interface ContaLocal extends JPADao<Conta,Integer> {

	public List<ContaBancaria> getContaBancaria();

	public List<CartaoDeCredito> getCartaoDeCredito();

	public List<CartaoDeCredito> getCobrancaBancaria();
}
