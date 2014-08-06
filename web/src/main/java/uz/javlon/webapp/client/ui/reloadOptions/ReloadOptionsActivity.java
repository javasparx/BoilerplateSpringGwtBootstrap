/**
 *
 */
package uz.javlon.webapp.client.ui.reloadOptions;

import com.github.gwtbootstrap.client.ui.constants.AlertType;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import uz.javlon.webapp.client.application.Application;
import uz.javlon.webapp.client.application.base.activity.AbstractBaseActivity;
import uz.javlon.webapp.client.proxies.LookupConstantsProxy;
import uz.javlon.webapp.client.ui.mainMenu.MainMenuPlace;

/**
 * @author ivangsa
 */
public class ReloadOptionsActivity extends AbstractBaseActivity {

    @Inject
    public ReloadOptionsActivity(final Application application) {
        super(application);
    }

    /* (non-Javadoc)
     * @see com.google.gwt.activity.shared.Activity#start(com.google.gwt.user.client.ui.AcceptsOneWidget, com.google.gwt.event.shared.EventBus)
     */
    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        requests.lookupRequest().reloadOptions().fire(new Receiver<LookupConstantsProxy>() {

            @Override
            public void onSuccess(final LookupConstantsProxy response) {
                application.setLookupConstants(response);
                placeController.goTo(new MainMenuPlace());
                shell.addMessage(i18n.reload_succeeded(), AlertType.SUCCESS);
            }

            @Override
            public void onFailure(final ServerFailure error) {
                super.onFailure(error);
            }
        });
    }

}
