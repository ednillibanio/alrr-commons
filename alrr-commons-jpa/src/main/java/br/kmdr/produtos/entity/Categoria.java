package br.kmdr.produtos.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.kmdr.core.entity.DominioEntity;

@Entity
public class Categoria extends DominioEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3918208099151758647L;

	@OneToMany
	private List<Categoria> subCategorias;

	public List<Categoria> getSubCategorias() {
		return subCategorias;
	}

	public void setSubCategorias(List<Categoria> subCategorias) {
		this.subCategorias = subCategorias;
	}
}
