package br.leg.rr.al.commons.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.leg.rr.al.core.jpa.Dominio;

/**
 * Classe persistente que representa a tabela "profissao".
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a>
 * @since 1.0.0
 */
@Entity
@Table
public class Profissao extends Dominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1389681015841528613L;

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
