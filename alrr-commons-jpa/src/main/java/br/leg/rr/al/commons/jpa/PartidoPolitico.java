package br.leg.rr.al.commons.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.search.annotations.Indexed;

import br.leg.rr.al.core.jpa.DominioIndexado;

/**
 * Classe persistente que representa a tabela "partido_politico".
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a>
 * @since 1.0.0
 */
@Entity
@Table(name = "partido_politico")
@Indexed
public class PartidoPolitico extends DominioIndexado {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1389681015841528613L;

	@Column(nullable = false, length = 6, unique = true)
	private String sigla;

	@Lob
	private byte[] logo;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
