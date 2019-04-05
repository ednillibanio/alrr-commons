package br.kmdr.imobil.entity.imovel;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "imovel_rural")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class ImovelRural extends Imovel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2901623310343683977L;

}
