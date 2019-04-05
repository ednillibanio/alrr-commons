/**
 * MenuListLocal.java
 * 19/07/2012
 * 
 * Copyright (c) 2012, KMDR. All rights reserved.
 * Boa Vista, RR - Brasil
 * Este software é propriedade da KMDR e não é permitida a
 * distribuição/alteração da mesma sem prévia autorização.
 *
 */
package br.kmdr.menu.service;

import java.util.List;

import javax.ejb.Local;

import br.kmdr.core.dao.JPADao;
import br.kmdr.menu.entity.Menu;

@Local
public interface MenuLocal extends JPADao<Menu, Integer> {

	/**
	 * 
	 * @return
	 */
	public List<Menu> findMenuPrincipal();
}
