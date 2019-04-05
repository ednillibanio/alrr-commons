package br.kmdr.commons.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.kmdr.util.entity.BaseEntity;

/**
 * 
 * @author Ednil Libanio
 */
@Entity
@Table(name = "dominio_valor")
public class DominioValor extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4503249666567010460L;

	@Column(nullable = true, length = 6)
	private String codigo;

	@Column(nullable = false, length = 70)
	private String label;

	@Column(nullable = false)
	private Boolean ativo = Boolean.TRUE;

	@Column(nullable = false)
	private Boolean editavel = Boolean.FALSE;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
