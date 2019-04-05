package br.kmdr.imobil.entity.imovel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.kmdr.util.entity.BaseEntity;

@Entity
@Table(name = "corretor")
// TODO: EStava extendendo PEssoa Fisica. Tem que arrumar isso depois.
public class Corretor extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 211935108885202066L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Remover depois que extender pessoa fisica.
	private Long id;

	@Column(length = 10, nullable = true, unique = true)
	private String creci;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Imobiliaria imobiliaria;

	@Column(nullable = false)
	private Boolean ativo = Boolean.TRUE;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name = "data_cadastro")
	private Date dataCadastroCorretor;

	public String getCreci() {
		return creci;
	}

	public void setCreci(String creci) {
		this.creci = creci;
	}

	public Imobiliaria getImobiliaria() {
		return imobiliaria;
	}

	public void setImobiliaria(Imobiliaria imobiliaria) {
		this.imobiliaria = imobiliaria;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Date getDataCadastroCorretor() {
		return dataCadastroCorretor;
	}

	public void setDataCadastroCorretor(Date dataCadastroCorretor) {
		this.dataCadastroCorretor = dataCadastroCorretor;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
