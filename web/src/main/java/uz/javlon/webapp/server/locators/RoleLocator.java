/**
 *
 */
package uz.javlon.webapp.server.locators;

import com.google.web.bindery.requestfactory.shared.Locator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.javlon.model.Role;
import uz.javlon.service.RoleManager;

/**
 * @author ivangsa
 */
@Component
public class RoleLocator extends Locator<Role, Long> {

    @Autowired
    private RoleManager roleManager;

    public Role create(Class<? extends Role> clazz) {
        return new Role();
    }

    public Role find(Class<? extends Role> clazz, Long id) {
        return roleManager.get(id);
    }

    public Class<Role> getDomainType() {
        return Role.class;
    }

    public Long getId(Role role) {
        return role.getId();
    }

    public Class<Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Role role) {
        return 0;
    }

    @Override
    public boolean isLive(Role domainObject) {
        return true;
    }
}
