package br.kmdr.menu.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.commons.lang.StringUtils;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.Submenu;

import br.kmdr.menu.entity.Menu;
import br.kmdr.menu.entity.MenuItem;
import br.kmdr.menu.service.MenuLocal;
import br.kmdr.util.web.controller.BasicController;

/**
 * @author Ednil Libanio
 * @date 19/07/2012
 * 
 */
@Named
@SessionScoped
// TODO: Melhorar, pois estamos com o sair, home e preferencias do usuario neste
// contexto. Temos que pensar numa maneira de colocar no banco de dados.
public class MenuController extends BasicController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -617825458952527257L;

	private static int cont = 0;

	private MenuModel model;

	@EJB
	MenuLocal menuListBean;

	private List<Menu> menus;

	public MenuController() {
		setModel(new DefaultMenuModel());
		if (menuListBean != null) {
			buildMenu();
		}
	}

	@PostConstruct
	public void init() {
		if (menuListBean != null) {
			setMenus(menuListBean.findMenuPrincipal());
			buildMenu();
		}
	}

	private String createMenuId() {
		return "mn_" + cont++;
	}

	private String createMenuItemId() {
		return "mni_" + cont++;
	}

	/**
	 * Método é chamado toda vez que o Model é solicitado por uma View, pois é
	 * necessário recriar os Id´s do menu para cada JSF.
	 */
	private void buildMenu() {

		for (Menu menu : getMenus()) {
			if ((menu.getMenuItems().size() > 0)
					|| (menu.getSubmenus().size() > 0)) {
				// Cria Menu Principal
				DefaultSubMenu menuPrincipal = new DefaultSubMenu();
				menuPrincipal.setId(createMenuId());
				menuPrincipal.setLabel(menu.getLabel());

				// Adiciona os MenusItems no primeiro nível, caso existam.
				/*if (menu.getMenuItems().size() > 0) {
					for (MenuItem mi : menu.getMenuItems()) {
						if (isUserInRole(mi.getFuncionalidade().getObjeto()))
							menuPrincipal.addElement(createMenuItem(mi));
					}
				}*/
				// Adiciona os Submenus no primeiro nível caso existam.
				if (menu.getSubmenus().size() > 0) {
					Submenu submenu = createSubmenu(menu);
					if (submenu.getElementsCount() > 0) {
						menuPrincipal.addElement(submenu);
					}

				}
				if (menuPrincipal.getElementsCount() > 0) {
					model.addElement(menuPrincipal);
				}
			}
		}

	}

	/**
	 * Cria os submenus recursivamente para cada menu superior.
	 * 
	 * @param menu
	 * @return retorna o submenu com o seus submenus ao final da recursividade.
	 *         Inclusive os items do menu.
	 */
	private DefaultSubMenu createSubmenu(Menu menu) {

		DefaultSubMenu menuSuperior = new DefaultSubMenu();

		for (Menu submenu : menu.getSubmenus()) {

			menuSuperior.setId(createMenuId());
			menuSuperior.setLabel(submenu.getLabel());

			// Adiciona os MenusItems no submenu caso existam.
			if (submenu.getMenuItems().size() > 0) {

				/*for (MenuItem mi : submenu.getMenuItems()) {
					if (isUserInRole(mi.getFuncionalidade().getObjeto()))
						menuSuperior.addElement(createMenuItem(mi));
				}*/
			}

			// Adiciona os submenus caso existam.
			if (submenu.getSubmenus().size() > 0) {
				DefaultSubMenu menuFilho = createSubmenu(submenu);
				// Só adiciona o submenu se ele tiver algum item.
				if (menuFilho.getElementsCount() > 0) {
					menuSuperior.addElement(menuFilho);
				}

			}
		}
		return menuSuperior;

	}

	/**
	 * Cria o MenuItem encontrado na base de dados com todas as configurações.
	 * Caso o campo action da entidade menu_item esteja vazia, o sistema vai
	 * preencher o valor da action do MenuItem do primefaces, com o valor que
	 * encontra no campo objeto da permissão. Além disso, ele incluirá o
	 * parametro faces-redirect=true. Com isso, reduz o trabalho no mapeamento
	 * do faces-config.
	 * 
	 * @param mi
	 *            menuitem que encontra na base de dados que será transformado
	 *            em MenuItem do primefaces.
	 * @return retorna o novo MenuItem.
	 */
	private DefaultMenuItem createMenuItem(MenuItem mi) {
		DefaultMenuItem menuItem = new DefaultMenuItem();

		// define o label do menuItem.
		//menuItem.setValue(mi.getFuncionalidade().getNome());
		menuItem.setId(createMenuItemId());

		// Define Action
		if (!StringUtils.isBlank(mi.getAction())) {
			menuItem.setCommand(mi.getAction());

			// Caso action seja null, então insere a url na action com a opção
			// de redirect.
		} else if (mi.getFuncionalidade() != null) {
			//menuItem.setCommand(mi.getFuncionalidade().getObjeto());
		}

		// Define ActionListner
		if (!StringUtils.isBlank(mi.getActionListener())) {
			menuItem.setCommand(mi.getActionListener());
		}

		return menuItem;
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}
