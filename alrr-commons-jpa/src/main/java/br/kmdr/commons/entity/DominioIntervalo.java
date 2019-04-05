package br.kmdr.commons.entity;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.kmdr.util.entity.BaseEntity;

/**
 * 
 * @author Ednil Libanio
 */
@Entity
@Table(name = "dominio_intervalo")
public class DominioIntervalo extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8825188650055843558L;

	@Basic(optional = false)
	@Column(name = "dominio", nullable = false)
	private short dominio;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "intervalo_inicial", precision = 6, scale = 2)
	private BigDecimal intervaloInicial;
	@Column(name = "intervalo_final", precision = 6, scale = 2)
	private BigDecimal intervaloFinal;
	@Basic(optional = false)
	@Column(name = "ativo", nullable = false)
	private boolean ativo;
	@Basic(optional = false)
	@Column(name = "editavel", nullable = false)
	private boolean editavel;

	public DominioIntervalo() {
	}

	public short getDominio() {
		return dominio;
	}

	public void setDominio(short dominio) {
		this.dominio = dominio;
	}

	public BigDecimal getIntervaloInicial() {
		return intervaloInicial;
	}

	public void setIntervaloInicial(BigDecimal intervaloInicial) {
		this.intervaloInicial = intervaloInicial;
	}

	public BigDecimal getIntervaloFinal() {
		return intervaloFinal;
	}

	public void setIntervaloFinal(BigDecimal intervaloFinal) {
		this.intervaloFinal = intervaloFinal;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean getEditavel() {
		return editavel;
	}

	public void setEditavel(boolean editavel) {
		this.editavel = editavel;
	}

}
