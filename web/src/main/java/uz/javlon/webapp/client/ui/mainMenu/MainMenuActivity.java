/**
 *
 */
package uz.javlon.webapp.client.ui.mainMenu;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import uz.javlon.webapp.client.application.Application;
import uz.javlon.webapp.client.application.base.activity.AbstractBaseActivity;

/**
 * @author ivangsa
 */
public class MainMenuActivity extends AbstractBaseActivity {


    private final MainMenuView view;

    @Inject
    public MainMenuActivity(final Application application, final MainMenuView view) {
        super(application);
        this.view = view;
        setTitle(i18n.mainMenu_title());
        setBodyId("home");
        setBodyClassname("home");
    }

    /* (non-Javadoc)
     * @see com.google.gwt.activity.shared.Activity#start(com.google.gwt.user.client.ui.AcceptsOneWidget, com.google.gwt.event.shared.EventBus)
     */
    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        panel.setWidget(view);
        setDocumentTitleAndBodyAttributtes();
    }

}
