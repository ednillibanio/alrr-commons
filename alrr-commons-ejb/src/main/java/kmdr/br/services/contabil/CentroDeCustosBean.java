package br.kmdr.imobil.service.contabil;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.kmdr.imobil.entity.contabil.CentroDeCustos;
import br.kmdr.util.dao.BaseDao;
import br.kmdr.util.service.BaseBeanException;

@Named
@Stateless
public class CentroDeCustosBean extends BaseDao<CentroDeCustos> implements
		CentroDeCustosLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4697472652550545966L;

	@Override
	public List<CentroDeCustos> findByCodigo(String codigo)
			throws BaseBeanException {
		return findByNamedQuery("CentroDeCustos.findByCodigo", "codigo", codigo
				.toUpperCase().concat("%"));
	}

	@Override
	public List<CentroDeCustos> findByNome(String nome)
			throws BaseBeanException {
		return findByNamedQuery("CentroDeCustos.findByNome", "nome", nome
				.toUpperCase().concat("%"));
	}

}
