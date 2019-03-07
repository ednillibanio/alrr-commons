package br.leg.rr.al.commons.web.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.leg.rr.al.commons.ejb.PartidoPoliticoLocal;
import br.leg.rr.al.commons.jpa.PartidoPolitico;
import br.leg.rr.al.core.dao.BeanException;
import br.leg.rr.al.core.web.controller.status.CompleteControllerEntityStatus;
import br.leg.rr.al.core.web.util.FacesMessageUtils;

@Named
@RequestScoped
public class PartidoPoliticoCompleteController extends CompleteControllerEntityStatus<PartidoPolitico, Integer> {

	@EJB
	PartidoPoliticoLocal bean;

	@Override
	public void init() {
		setBean(bean);
	}

	/**
	 * Método usado para buscar Localidades. A busca é realizada por parte do nome
	 * informado.
	 * 
	 * @param nome
	 * @return lista de localidades. <code>null </code> se nenhum encontrado.
	 */
	public List<PartidoPolitico> completePorSigla(String sigla) {
		// FIXME: melhorar o método para carregar legal no autocomplete.
		try {
			return bean.buscarPorSigla(sigla);
		} catch (BeanException e) {
			FacesMessageUtils.addFatal(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

}
