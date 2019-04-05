package br.kmdr.financeiro.service;

import java.util.List;

import javax.ejb.Local;

import br.kmdr.core.dao.JPADao;
import br.kmdr.financeiro.entity.Banco;

@Local
public interface BancoLocal extends JPADao<Banco, Integer> {

	public Banco findByCodigo(String codigo);

	public List<Banco> buscarPorNome(String nome);

}
