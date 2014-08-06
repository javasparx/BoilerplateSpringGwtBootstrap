/**
 *
 */
package uz.javlon.webapp.client.proxies;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;
import uz.javlon.webapp.server.services.UsersSearchCriteria;

/**
 * @author ivangsa
 */
@ProxyFor(UsersSearchCriteria.class)
public interface UsersSearchCriteriaProxy extends ValueProxy {

    String getSearchTerm();

    void setSearchTerm(String searchTerm);
}
