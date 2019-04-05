/**
 * Menu.java
 * 19/07/2012
 * 
 * Copyright (c) 2012, KMDR. All rights reserved.
 * Boa Vista, RR - Brasil
 * Este software é propriedade da KMDR e não é permitida a
 * distribuição/alteração da mesma sem prévia autorização.
 *
 */
package br.kmdr.menu.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import br.kmdr.core.entity.BaseEntity;

/**
 * @author Ednil Libanio
 * @date 19/07/2012
 * 
 */
@Entity
@Table
@NamedQueries({ @NamedQuery(name = Menu.FIND_MENUS_PRINCIPAL, query = "SELECT  m "
		+ "FROM  Menu m WHERE m.menuSuperior is null"), })
public class Menu extends BaseEntity<Integer> {

	public static final String FIND_MENUS_PRINCIPAL = "Menu.findMenuPrincipal";

	/**
	 * 
	 */
	private static final long serialVersionUID = 4351103253727217910L;

	@Column(length = 500, unique = true)
	@OrderBy
	private String label;

	@ManyToOne(optional = true)
	@JoinColumn(name = "menu_superior_id", referencedColumnName = "id")
	private Menu menuSuperior;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "menuSuperior", fetch = FetchType.EAGER)
	@OrderBy("label ASC")
	private List<Menu> submenus;

	@OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
	private List<MenuItem> menuItems;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Menu> getSubmenus() {
		return submenus;
	}

	public void setSubmenus(List<Menu> submenus) {
		this.submenus = submenus;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public Menu getMenuSuperior() {
		return menuSuperior;
	}

	public void setMenuSuperior(Menu menuSuperior) {
		this.menuSuperior = menuSuperior;
	}

}
