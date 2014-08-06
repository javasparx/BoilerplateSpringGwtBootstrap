package uz.javlon.webapp.client.application;


import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import uz.javlon.webapp.client.application.base.security.LoginEvent;
import uz.javlon.webapp.client.application.base.security.LogoutEvent;
import uz.javlon.webapp.client.requests.ApplicationRequestFactory;
import uz.javlon.webapp.client.ui.Shell;


/**
 * Application for browsing entities.
 */
public class MobileApplication extends DesktopApplication implements LoginEvent.Handler, LogoutEvent.Handler {

    @Inject
    public MobileApplication(
            final Shell shell,
            final ApplicationMenu menu,
            final ApplicationRequestFactory requestFactory,
            final EventBus eventBus,
            final PlaceController placeController,
            final PlaceHistoryHandler placeHistoryHandler,
            final ActivityManager activityManager,
            final ApplicationProxyFactory proxyFactory,
            final ApplicationValidatorFactory validatorFactory) {
        super(shell, menu, requestFactory, eventBus, placeController, placeHistoryHandler, activityManager, proxyFactory, validatorFactory);
    }
}
