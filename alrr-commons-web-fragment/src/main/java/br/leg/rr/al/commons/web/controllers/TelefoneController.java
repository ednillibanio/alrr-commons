package br.leg.rr.al.commons.web.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.leg.rr.al.commons.domain.TelefoneType;
import br.leg.rr.al.commons.ejb.TelefoneLocal;
import br.leg.rr.al.commons.jpa.Telefone;

@Named
@ViewScoped
public class TelefoneController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8435915250149790833L;

	/*-------------------------------------------
	|             V A R I A V E I S             |
	===========================================*/

	private Telefone telefone;

	private List<Telefone> telefones;

	private Telefone celular;

	private Telefone telefoneFixo;

	private Telefone telefoneComercial;

	private Telefone telefoneResidencial;

	private Telefone fax;

	@PostConstruct
	public void init() {
		telefone = new Telefone();
		// telefones = new HashSet<Telefone>();
		telefones = new ArrayList<Telefone>();
		Telefone teste = new Telefone();
		teste.setTipo(TelefoneType.CELULAR);
		teste.setDdd("95");
		teste.setNumero("981142006");
		telefones.add(teste);
	}

	/*----------------------------------
	|             E J B´ S             |
	==================================*/

	@EJB
	private TelefoneLocal telefoneBean;

	/**
	 * Responsável por preencher as variaveis de telefone a partir do banco de
	 * dados.
	 * 
	 * @param tels lista com os telefones que foram carregados a partir do banco de
	 *             dados e que vão ser usados pra preencher as variaveis de
	 *             telefone.
	 */
	public void preencherTelefones(Set<Telefone> tels) {
		// preenche os telefones celular e fixo.
		if (tels != null && tels.size() > 0) {
			for (Telefone tel : tels) {

				if (tel.getTipo() == TelefoneType.CELULAR) {
					setCelular(tel);

				} else if (tel.getTipo() == TelefoneType.FIXO) {
					setTelefoneFixo(tel);

				} else if (tel.getTipo() == TelefoneType.COMERCIAL) {
					setTelefoneComercial(tel);

				} else if (tel.getTipo() == TelefoneType.RESIDENCIAL) {
					setTelefoneResidencial(tel);
				} else if (tel.getTipo() == TelefoneType.FAX) {
					setFax(tel);
				}

			}
		}
	}

	/**
	 * Adiciona os telefones informados pelo usuário na tela de cadastro a entidade
	 * {@link Pessoa}.
	 * 
	 * @param pessoa entidade que será atribuida os telefones informados pelo
	 *               usuário.
	 */
	protected void adicionarTelefones(Set<Telefone> tels) {
		atualizarTelefones(tels);
	}

	/**
	 * Método responsável por adicionar ou remover telefones associados a entidade
	 * {@link Pessoa}.
	 * 
	 * @param pessoa
	 */
	protected void atualizarTelefones(Set<Telefone> tels) {

		if (tels != null) {

			atualizarCelular(tels);
			atualizarFixo(tels);
			atualizarComercial(tels);
			atualizarFax(tels);
		}

	}

	private void atualizarFax(Set<Telefone> tels) {

		if (getFax() != null) {

			if (StringUtils.isNotBlank(getFax().getNumero())) {

				if (getFax().getId() == null) { // verifica se o telefone informado é novo.
					getFax().setTipo(TelefoneType.FAX);
					tels.add(getFax());

				} else { // se não for, verifica se mudou o númrero e o atualiza.
					atualizarNumeroTelefone(getFax(), tels);
				}
			}
		} else {
			removerTelefone(TelefoneType.FAX, tels);
		}

	}

	private void atualizarComercial(Set<Telefone> tels) {

		if (getTelefoneComercial() != null) {

			if (StringUtils.isNotBlank(getTelefoneComercial().getNumero())) {

				if (getTelefoneComercial().getId() == null) {// verifica se o telefone informado é novo.
					getTelefoneComercial().setTipo(TelefoneType.COMERCIAL);
					tels.add(getTelefoneComercial());
				} else { // se não for, verifica se mudou o númrero e o atualiza
					atualizarNumeroTelefone(getTelefoneComercial(), tels);
				}
			}
		} else {
			removerTelefone(TelefoneType.COMERCIAL, tels);
		}

	}

	private void atualizarFixo(Set<Telefone> tels) {

		if (getTelefoneFixo() != null) {

			if (StringUtils.isNotBlank(getTelefoneFixo().getNumero())) {

				if (getTelefoneFixo().getId() == null) {// verifica se o telefone informado é novo.
					getTelefoneFixo().setTipo(TelefoneType.FIXO);
					tels.add(getTelefoneFixo());
				} else {// se não for, verifica se mudou o númrero e o atualiza
					atualizarNumeroTelefone(getTelefoneFixo(), tels);
				}
			}

		} else {
			removerTelefone(TelefoneType.FIXO, tels);
		}
	}

	private void atualizarCelular(Set<Telefone> tels) {

		if (getCelular() != null) {

			if (StringUtils.isNotBlank(getCelular().getNumero())) {

				if (getCelular().getId() == null) { // verifica se o telefone informado é novo.
					getCelular().setTipo(TelefoneType.CELULAR);
					tels.add(getCelular());
				} else { // se não for, verifica se mudou o númrero e o atualiza
					atualizarNumeroTelefone(getCelular(), tels);
				}
			}
		} else {
			removerTelefone(TelefoneType.CELULAR, tels);
		}

	}

	/**
	 * 
	 * @param origem
	 * @param tels
	 */
	private void atualizarNumeroTelefone(Telefone origem, Set<Telefone> tels) {
		for (Telefone destino : tels) {
			if (destino.getId() == origem.getId()) {
				if (destino.getDdd() != origem.getDdd()) {
					destino.setDdd(origem.getDdd());
				}
				if (destino.getNumero() != origem.getNumero()) {
					destino.setNumero(origem.getNumero());
				}
			}
		}

	}

	/**
	 * 
	 * @param origem
	 * @param tels
	 */
	private void removerTelefone(TelefoneType tipo, Set<Telefone> tels) {
		for (Telefone destino : tels) {
			if (destino.getTipo() == tipo) {
				tels.remove(destino);
			}
		}

	}

	public Telefone getCelular() {
		return celular;
	}

	public void setCelular(Telefone celular) {
		this.celular = celular;
	}

	public Telefone getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(Telefone telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public Telefone getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(Telefone telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public Telefone getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(Telefone telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public Telefone getFax() {
		return fax;
	}

	public void setFax(Telefone fax) {
		this.fax = fax;
	}

	/**
	 * @return the telefone
	 */
	public Telefone getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the telefones
	 */
	public List<Telefone> getTelefones() {
		return telefones;
	}

	/**
	 * @param telefones the telefones to set
	 */
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

}
