package br.kmdr.menu.service;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.kmdr.core.dao.JPABaseDao;
import br.kmdr.menu.entity.MenuItem;

@Named
@Stateless
public class MenuItemBean extends JPABaseDao<MenuItem, Integer> implements
		MenuItemLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3978037977765150873L;

	@Override
	public MenuItem findByAction(String action) {
		return findEntity(MenuItem.FIND_BY_ACTION, "action", action);
	}

}
