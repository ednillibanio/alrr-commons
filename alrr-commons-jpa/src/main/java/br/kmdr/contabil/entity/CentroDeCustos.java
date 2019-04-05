package br.kmdr.contabil.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import br.kmdr.core.entity.BaseEntity;

/**
 * São os setores ou departamentos da empresa. Os centros de custos são
 * utilizados para descobrir quanto cada setor ou departamento da empresa
 * gastou.
 * 
 * @author ednil
 *
 */
@Entity
@Table(name = "centro_de_custos")
public class CentroDeCustos extends BaseEntity<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3041212538840345960L;

	// unique é aplicado ao conjunto e não individual neste caso. por isso não
	// tem o unique aqui.
	@Column(length = 250, nullable = false)
	@OrderBy
	private String nome;

	@Column(nullable = true, length = 8, unique = true)
	private String codigo;

	@ManyToOne(optional = true)
	@JoinColumn(name = "categoria_id", referencedColumnName = "id")
	private PlanoDeContas categoria;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria", fetch = FetchType.EAGER)
	@OrderBy("nome ASC")
	private List<PlanoDeContas> subCategorias;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PlanoDeContas getCategoria() {
		return categoria;
	}

	public void setCategoria(PlanoDeContas categoria) {
		this.categoria = categoria;
	}

	public List<PlanoDeContas> getSubCategorias() {
		return subCategorias;
	}

	public void setSubCategorias(List<PlanoDeContas> subCategorias) {
		this.subCategorias = subCategorias;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
