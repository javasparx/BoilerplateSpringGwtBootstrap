/**
 *
 */
package uz.javlon.webapp.client.ui.users.active;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.IsWidget;
import uz.javlon.webapp.client.proxies.UserProxy;

/**
 * @author ivangsa
 */
public interface ActiveUsersView extends IsWidget {

    interface Delegate {
        void cancelClicked();
    }

    /**
     * Sets the delegate.
     */
    void setDelegate(Delegate delegate);


    /**
     * @return
     */
    CellTable<UserProxy> getCellTable();

    /**
     * @return the set of properties this view displays
     */
    String[] getPaths();

}
