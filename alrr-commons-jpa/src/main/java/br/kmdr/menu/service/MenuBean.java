package br.kmdr.menu.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.kmdr.core.dao.JPABaseDao;
import br.kmdr.menu.entity.Menu;

@Stateless
@Named
public class MenuBean extends JPABaseDao<Menu, Integer> implements MenuLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3383929012991350663L;

	@Override
	public List<Menu> findMenuPrincipal() {
		return findByNamedQuery(Menu.FIND_MENUS_PRINCIPAL);
	}
}
