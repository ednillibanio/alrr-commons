/*******************************************************************************
 * Copyright (c) 2017, KMDR Consultoria e Serviços, Boa Vista, RR - Brasil.
 * Todos os direitos reservados. Este programa é propriedade da Assembleia Legislativa do Estado de Roraima e não é permitida a distribuição, alteração ou cópia da mesma sem prévia autoriazação.
 ******************************************************************************/
package br.leg.rr.al.commons.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.leg.rr.al.commons.domain.FeriadoType;
import br.leg.rr.al.commons.ejb.FeriadoLocal;
import br.leg.rr.al.commons.jpa.Feriado;
import br.leg.rr.al.core.CoreUtilsValidationMessages;
import br.leg.rr.al.core.domain.Mes;
import br.leg.rr.al.core.web.controller.status.DominioController;
import br.leg.rr.al.core.web.util.FacesMessageUtils;

/**
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a><br/>
 *         Data Criação: 22-08-2012<br/>
 * @since 1.0.0
 */
@Named
@ViewScoped
public class FeriadoController extends DominioController<Feriado> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7882112613545512515L;
	@EJB
	private FeriadoLocal bean;

	// Variaveis de pesquisa
	private String nome;
	private FeriadoType tipo;
	private List<FeriadoType> tiposSelecionados;
	private List<Mes> mesesSelecionados;

	@PostConstruct
	public void init() {
		setBean(bean);
		jaExisteMsg = "Feriado já existe.";

		setNovoDialogName("dlg-feriado");
		setEditarDialogName("dlg-feriado");
	}

	/**
	 * <p>
	 * Responsável por definir valor 'null' para os campos municipio e uf de acordo
	 * com o tipo do feriado antes de ser chamado o método {@link #salvar()}. Esse
	 * método garante que valores inconsistentes não sejam inseridos.
	 * </p>
	 * <p>
	 * Por exemplo, se o tipo do feriado for Nacional, então definirá o valor null
	 * para municipio e uf. Caso o tipo seja Estadual, definirá o valor null somente
	 * para municipio.
	 * </p>
	 * 
	 */
	@Override
	protected void preInserir() {
		super.preInserir();
		if (getEntity().getTipo().equals(FeriadoType.NACIONAL)) {
			getEntity().setMunicipio(null);
			getEntity().setUf(null);
		} else if (getEntity().getTipo().equals(FeriadoType.ESTADUAL)) {
			getEntity().setMunicipio(null);
		}
	}

	/**
	 * <p>
	 * Responsável por definir valor 'null' para os campos municipio e uf de acordo
	 * com o tipo do feriado antes de ser chamado o método {@link #salvar()}. Esse
	 * método garante que valores inconsistentes sejam inseridos no momento da
	 * edição da entidade.
	 * </p>
	 * <p>
	 * Por exemplo, se o tipo do feriado for Nacional, então definirá o valor null
	 * para municipio e uf. Caso o tipo seja Estadual, definirá o valor null somente
	 * para municipio.
	 * </p>
	 * 
	 */
	@Override
	protected void preAtualizar() {
		if (getEntity().getTipo().equals(FeriadoType.NACIONAL)) {
			getEntity().setMunicipio(null);
			getEntity().setUf(null);
		} else if (getEntity().getTipo().equals(FeriadoType.ESTADUAL)) {
			getEntity().setMunicipio(null);
		}
	}

	@Override
	public String pesquisar() {

		Map<String, Object> filtros = new HashMap<String, Object>();
		filtros.put(FeriadoLocal.PESQUISAR_PARAM_NOME, nome);
		filtros.put(FeriadoLocal.PESQUISAR_PARAM_MESES, getMesesSelecionados());
		filtros.put(FeriadoLocal.PESQUISAR_PARAM_TIPOS, getTiposSelecionados());

		setEntities(bean.pesquisar(filtros));
		if (getEntities().size() > 0) {
			createDataModel(getEntities());
		} else {
			FacesMessageUtils.addError(CoreUtilsValidationMessages.REGISTRO_NAO_ENCONTRADO);
		}

		return null;
	}

	public void mudarSituacao() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public FeriadoType getTipo() {
		return tipo;
	}

	public void setTipo(FeriadoType tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the tiposSelecionados
	 */
	public List<FeriadoType> getTiposSelecionados() {
		return tiposSelecionados;
	}

	/**
	 * @param tiposSelecionados the tiposSelecionados to set
	 */
	public void setTiposSelecionados(List<FeriadoType> tiposSelecionados) {
		this.tiposSelecionados = tiposSelecionados;
	}

	/**
	 * @return the mesesSelecionados
	 */
	public List<Mes> getMesesSelecionados() {
		return mesesSelecionados;
	}

	/**
	 * @param mesesSelecionados the mesesSelecionados to set
	 */
	public void setMesesSelecionados(List<Mes> mesesSelecionados) {
		this.mesesSelecionados = mesesSelecionados;
	}
}