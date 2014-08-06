/**
 *
 */
package uz.javlon.webapp.client.ui;

import com.github.gwtbootstrap.client.ui.base.AlertBase;
import com.github.gwtbootstrap.client.ui.constants.AlertType;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.NotificationMole;
import com.google.gwt.user.client.ui.SimplePanel;
import uz.javlon.webapp.client.application.Application;
import uz.javlon.webapp.client.application.base.security.LoginEvent;
import uz.javlon.webapp.client.application.base.security.LogoutEvent;

/**
 * @author ivangsa
 */
public abstract class Shell extends Composite implements LoginEvent.Handler, LogoutEvent.Handler {

    protected Application application;

    @UiField
    SimplePanel contentsPanel;

    /**
     * Contents Panel
     *
     * @return
     */
    public SimplePanel getContentsPanel() {
        return contentsPanel;
    }

    public void clearMessages() {
        // TODO Auto-generated method stub
    }

    public void addMessage(AlertBase alert) {
        //TODO
    }

    public void addMessage(String html, AlertType alertType) {
        // TODO
    }

    public NotificationMole getMole() {
        return null;
    }

    public void setApplication(Application application) {
        this.application = application;
    }


}
