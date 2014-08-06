/**
 *
 */
package uz.javlon.webapp.client.proxies;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;
import uz.javlon.model.LabelValue;

/**
 * @author ivangsa
 */
@ProxyFor(LabelValue.class)
public interface LabelValueProxy extends ValueProxy {

    String getLabel();

    void setLabel(String label);

    String getValue();

    void setValue(String value);

}
