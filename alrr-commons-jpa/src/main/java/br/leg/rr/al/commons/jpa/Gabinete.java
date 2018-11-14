package br.leg.rr.al.commons.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.leg.rr.al.core.jpa.Dominio;

/**
 * Classe persistente que representa a tabela "gabinete".
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a>
 * @since 1.0.0
 */
@Entity
@Table
public class Gabinete extends Dominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1389681015841528613L;

	private String andar;

	private String sala;

}
