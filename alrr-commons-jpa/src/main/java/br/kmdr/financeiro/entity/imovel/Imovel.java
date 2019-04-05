package br.kmdr.imobil.entity.imovel;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.kmdr.imobil.entity.commons.DominioValor;
import br.kmdr.imobil.entity.commons.Endereco;
import br.kmdr.imobil.entity.pessoa.Pessoa;
import br.kmdr.util.entity.BaseEntity;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Imovel extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2127741715960090159L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 9)
	private Long id;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "imovel_proprietario", joinColumns = @JoinColumn(name = "imovel_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pessoa_id", referencedColumnName = "id"))
	private List<Pessoa> proprietarios;

	@OneToOne(optional = true, orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinTable(name = "endereco", joinColumns = @JoinColumn(name = "imovel_id", referencedColumnName = "id", nullable = true), inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
	private Endereco endereco;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(name = "imovel_foto", joinColumns = @JoinColumn(name = "imovel_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
	private List<ImovelAnexo> fotos;

	@ManyToOne
	@JoinColumn(name = "tipo_imovel_id", nullable = true)
	private DominioValor tipoImovel;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	public List<Pessoa> getProprietarios() {
		return proprietarios;
	}

	public void setProprietarios(List<Pessoa> proprietarios) {
		this.proprietarios = proprietarios;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<ImovelAnexo> getFotos() {
		return fotos;
	}

	public void setFotos(List<ImovelAnexo> fotos) {
		this.fotos = fotos;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public DominioValor getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(DominioValor tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

}
