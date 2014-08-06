/**
 *
 */
package uz.javlon.webapp.client.proxies;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;
import uz.javlon.webapp.server.services.LookupRequestService.LookupConstants;

import java.util.List;

/**
 * @author ivangsa
 */
@ProxyFor(LookupConstants.class)
public interface LookupConstantsProxy extends ValueProxy {

    List<RoleProxy> getAvailableRoles();

    void setAvailableRoles(List<RoleProxy> availableRoles);

    List<LabelValueProxy> getCountries();

    void setCountries(List<LabelValueProxy> countries);
}
