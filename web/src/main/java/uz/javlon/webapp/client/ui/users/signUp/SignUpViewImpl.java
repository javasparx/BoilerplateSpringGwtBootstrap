/**
 *
 */
package uz.javlon.webapp.client.ui.users.signUp;

import uz.javlon.webapp.client.ui.users.editUser.EditUserViewImpl;

/**
 * @author ivangsa
 */
public class SignUpViewImpl extends EditUserViewImpl implements SignUpView {

    /**
     *
     */
    public SignUpViewImpl() {
        super();
        subheading.setText(i18n.signup_message());
        passwordControlGroup.setVisible(true);
        updatePasswordControl.removeFromParent();
        accountSettings.removeFromParent();
        userRoles.removeFromParent();
        deleteButton.removeFromParent();
    }


}