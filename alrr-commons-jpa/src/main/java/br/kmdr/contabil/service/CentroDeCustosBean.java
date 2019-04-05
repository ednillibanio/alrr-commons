package br.kmdr.contabil.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.kmdr.contabil.entity.CentroDeCustos;
import br.kmdr.core.dao.JPABaseDao;
import br.kmdr.util.service.BeanException;

@Named
@Stateless
public class CentroDeCustosBean extends JPABaseDao<CentroDeCustos, Integer> implements CentroDeCustosLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4697472652550545966L;

	@Override
	public List<CentroDeCustos> findByCodigo(String codigo) throws BeanException {
		return findByNamedQuery("CentroDeCustos.findByCodigo", "codigo", codigo.toUpperCase().concat("%"));
	}

	@Override
	public List<CentroDeCustos> buscarPorNome(String nome) throws BeanException {
		return findByNamedQuery("CentroDeCustos.findByNome", "nome", nome.toUpperCase().concat("%"));
	}

}
