package br.kmdr.contabil.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.kmdr.contabil.entity.PlanoDeContas;
import br.kmdr.core.dao.JPABaseDao;
import br.kmdr.util.service.BeanException;

@Named
@Stateless
public class PlanoDeContasBean extends JPABaseDao<PlanoDeContas,Integer> implements PlanoDeContasLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6384256771599384685L;

	@Override
	public List<PlanoDeContas> findByCodigo(String codigo) throws BeanException {
		return findByNamedQuery("PlanoDeContas.findByCodigo", "codigo", codigo.toUpperCase().concat("%"));
	}

	@Override
	public List<PlanoDeContas> buscarPorNome(String nome) throws BeanException {
		return findByNamedQuery("PlanoDeContas.findByNome", "nome", nome.toUpperCase().concat("%"));
	}

}
