package br.kmdr.imobil.entity.imovel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.kmdr.imobil.entity.pessoa.PessoaJuridica;

@Entity
@Table(name = "imobiliaria")
public class Imobiliaria extends PessoaJuridica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4442491286946631598L;

	@Column(length = 10, nullable = true, unique = true)
	private String creci;

	public String getCreci() {
		return creci;
	}

	public void setCreci(String creci) {
		this.creci = creci;
	}

}
