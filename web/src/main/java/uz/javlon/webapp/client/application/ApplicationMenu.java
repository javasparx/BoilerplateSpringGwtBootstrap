/**
 *
 */
package uz.javlon.webapp.client.application;

import com.google.gwt.core.client.GWT;
import uz.javlon.webapp.client.application.base.place.EntitySearchPlace;
import uz.javlon.webapp.client.application.utils.menu.MenuItem;
import uz.javlon.webapp.client.proxies.RoleProxy;
import uz.javlon.webapp.client.proxies.UserProxy;
import uz.javlon.webapp.client.ui.login.LoginPlace;
import uz.javlon.webapp.client.ui.logout.LogoutPlace;
import uz.javlon.webapp.client.ui.mainMenu.MainMenuPlace;
import uz.javlon.webapp.client.ui.reloadOptions.ReloadOptionsPlace;
import uz.javlon.webapp.client.ui.upload.FileUploadPlace;
import uz.javlon.webapp.client.ui.users.active.ActiveUsersPlace;
import uz.javlon.webapp.client.ui.users.editProfile.EditProfilePlace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ivangsa
 */
public class ApplicationMenu {

    private static final ApplicationResources i18n = GWT.create(ApplicationResources.class);

    private MenuItem rootMenu = new MenuItem(null);
    private MenuItem adminMenu = new MenuItem(i18n.menu_admin(), RoleProxy.ROLE_ADMIN);

    private List<MenuItem> allMenuItems;

    {
        rootMenu.add(new MenuItem(i18n.mainMenu_title(), new MainMenuPlace(), RoleProxy.ROLE_USER, RoleProxy.ROLE_ADMIN));
        rootMenu.add(new MenuItem(i18n.menu_user(), new EditProfilePlace(), RoleProxy.ROLE_USER, RoleProxy.ROLE_ADMIN));

        rootMenu.add(adminMenu);
        adminMenu.add(new MenuItem(i18n.menu_admin_users(), new EntitySearchPlace(UserProxy.class), RoleProxy.ROLE_ADMIN));
        adminMenu.add(new MenuItem(i18n.mainMenu_activeUsers(), new ActiveUsersPlace(), RoleProxy.ROLE_ADMIN));
        adminMenu.add(new MenuItem(i18n.menu_admin_reload(), new ReloadOptionsPlace(), RoleProxy.ROLE_ADMIN));
        adminMenu.add(new MenuItem(i18n.menu_selectFile(), new FileUploadPlace(), RoleProxy.ROLE_ADMIN));

        rootMenu.add(new MenuItem(i18n.login_title(), new LoginPlace(), RoleProxy.ANONYMOUS));
        rootMenu.add(new MenuItem(i18n.user_logout(), new LogoutPlace(), RoleProxy.AUTHENTICATED));
    }

    public MenuItem getRootMenu() {
        return rootMenu;
    }

    public List<MenuItem> asList() {
        if (allMenuItems == null) {
            allMenuItems = new ArrayList<MenuItem>();
            appendChildrenToList(allMenuItems, rootMenu);
        }
        return allMenuItems;
    }

    protected void appendChildrenToList(List<MenuItem> menuItems, MenuItem menuItem) {
        for (MenuItem childItem : menuItem) {
            menuItems.add(childItem);
            appendChildrenToList(menuItems, childItem);
        }
    }
}
