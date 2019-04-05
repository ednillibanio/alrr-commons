package br.kmdr.financeiro.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.kmdr.core.dao.JPABaseDao;
import br.kmdr.financeiro.entity.Banco;

@Named
@Stateless
public class BancoBean extends JPABaseDao<Banco, Integer> implements BancoLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7641500888870969137L;

	@Override
	public Banco findByCodigo(String codigo) {
		return findEntity("Banco.findByCodigo", "codigo", codigo);
	}

	@Override
	public List<Banco> buscarPorNome(String nome) {
		return findByNamedQuery("Banco.findByNome", "nome", "%".concat(nome.toUpperCase().concat("%")));
	}
}
