/**
 *
 */
package uz.javlon.webapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import uz.javlon.webapp.client.application.ioc.ClientInjector;

/**
 * @author ivangsa
 */
public class MainEntryPoint implements EntryPoint {

    final private ClientInjector injectorWrapper = GWT.create(ClientInjector.class);

    public void onModuleLoad() {
        /* Get and run platform specific app */
        injectorWrapper.getApplication().run();
    }

}
