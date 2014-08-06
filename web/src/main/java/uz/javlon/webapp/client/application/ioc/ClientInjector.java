package uz.javlon.webapp.client.application.ioc;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import uz.javlon.webapp.client.application.Application;

@GinModules(value = {ClientGinModule.class})
public interface ClientInjector extends Ginjector {

    Application getApplication();
}
