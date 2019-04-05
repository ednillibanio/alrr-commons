package br.kmdr.imobil.service.contabil;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.kmdr.imobil.entity.contabil.PlanoDeContas;
import br.kmdr.util.dao.BaseDao;
import br.kmdr.util.service.BaseBeanException;

@Named
@Stateless
public class PlanoDeContasBean extends BaseDao<PlanoDeContas> implements
		PlanoDeContasLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6384256771599384685L;

	@Override
	public List<PlanoDeContas> findByCodigo(String codigo)
			throws BaseBeanException {
		return findByNamedQuery("PlanoDeContas.findByCodigo", "codigo", codigo
				.toUpperCase().concat("%"));
	}

	@Override
	public List<PlanoDeContas> findByNome(String nome) throws BaseBeanException {
		return findByNamedQuery("PlanoDeContas.findByNome", "nome", nome
				.toUpperCase().concat("%"));
	}

}
