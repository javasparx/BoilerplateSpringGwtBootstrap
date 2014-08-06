/**
 *
 */
package uz.javlon.webapp.client.application;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;
import uz.javlon.webapp.client.proxies.UserProxy;
import uz.javlon.webapp.client.ui.login.LoginView;
import uz.javlon.webapp.client.ui.upload.FileUploadBean;
import uz.javlon.webapp.client.ui.users.updatePassword.UpdatePasswordView;

import javax.validation.Validator;

/**
 * @author ivangsa
 */
public class ApplicationValidatorFactory extends AbstractGwtValidatorFactory {

    @GwtValidation({
            LoginView.LoginDetails.class,
            UpdatePasswordView.UserCredentials.class,
            UserProxy.class,
            FileUploadBean.class
    })
    public interface GwtValidator extends Validator {
    }

    @Override
    public AbstractGwtValidator createValidator() {
        return GWT.create(GwtValidator.class);
    }

}
