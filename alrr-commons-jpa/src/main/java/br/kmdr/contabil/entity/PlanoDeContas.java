package br.kmdr.contabil.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.kmdr.core.domain.PlanoDeContasType;
import br.kmdr.core.entity.BaseEntity;

@Entity
@Table(name = "plano_de_contas")
public class PlanoDeContas extends BaseEntity<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2566316689302159661L;

	@Column(length = 250, nullable = false)
	@OrderBy
	private String nome;

	@Column(nullable = true, length = 8, unique = true)
	private String codigo;

	@ManyToOne(optional = true)
	@JoinColumn(name = "categoria_id", referencedColumnName = "id", nullable = true)
	private PlanoDeContas categoria;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria", fetch = FetchType.EAGER)
	@OrderBy("nome ASC")
	private List<PlanoDeContas> subCategorias;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_plano", nullable = false)
	private PlanoDeContasType tipoPlano;

	@Column(nullable = false)
	private Boolean ativo = Boolean.TRUE;

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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public PlanoDeContasType getTipoPlano() {
		return tipoPlano;
	}

	public void setTipoPlano(PlanoDeContasType tipoPlano) {
		this.tipoPlano = tipoPlano;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
