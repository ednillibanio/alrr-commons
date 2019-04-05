package br.kmdr.menu.service;

import javax.ejb.Local;

import br.kmdr.core.dao.JPADao;
import br.kmdr.menu.entity.MenuItem;

@Local
public interface MenuItemLocal extends JPADao<MenuItem, Integer> {

	public MenuItem findByAction(String action);
}
