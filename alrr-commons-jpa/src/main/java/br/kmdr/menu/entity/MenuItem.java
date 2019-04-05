/**
 * MenuItem.java
 * 19/07/2012
 * 
 * Copyright (c) 2012, KMDR. All rights reserved.
 * Boa Vista, RR - Brasil
 * Este software é propriedade da KMDR e não é permitida a
 * distribuição/alteração da mesma sem prévia autorização.
 *
 */
package br.kmdr.menu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import br.kmdr.core.entity.BaseEntity;
import br.kmdr.sistema.entity.Funcionalidade;

/**
 * @author Ednil Libanio
 * @date 19/07/2012
 * 
 */
@Entity
@Table(name = "menu_item")
@NamedQueries({ @NamedQuery(name = MenuItem.FIND_BY_ACTION, query = "SELECT  mi FROM  MenuItem mi "
		+ "WHERE  mi.action = :action"), })
public class MenuItem extends BaseEntity<Integer> {

	public static final String FIND_BY_ACTION = "MenuItem.findByAction";

	private static final long serialVersionUID = 5402686540843335448L;

	/**
	 * Label do menuItem.
	 */
	@Column(length = 250)
	private String value;

	/**
	 * Action que é invocado quando menuItem é clicado.
	 */
	@Column(unique = true, length = 250, nullable = true)
	private String action;

	/**
	 * Action Listener que é invocado quando menuItem é clicado.
	 */
	@Column(unique = true, length = 250, nullable = true, name = "action_listener")
	private String actionListener;

	@Column(unique = false, length = 250, nullable = true)
	private String onclick;

	@ManyToOne(optional = false)
	private Menu menu;

	@OneToOne(optional = true)
	@JoinColumn(name = "funcionalidade_id", unique = true)
	@OrderBy("nome ASC")
	private Funcionalidade funcionalidade;

	public String getValue() {
		return value;
	}

	/**
	 * Define o label do menuItem.
	 * 
	 * @param value
	 *            label do menuItem.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getActionListener() {
		return actionListener;
	}

	public void setActionListener(String actionListener) {
		this.actionListener = actionListener;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}
}
