/**
 *
 */
package uz.javlon.webapp.client.application;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;
import uz.javlon.webapp.client.application.base.activity.AsyncActivityProxy;
import uz.javlon.webapp.client.application.base.place.EntityProxyPlace;
import uz.javlon.webapp.client.application.base.place.EntitySearchPlace;
import uz.javlon.webapp.client.proxies.UserProxy;
import uz.javlon.webapp.client.ui.login.LoginActivity;
import uz.javlon.webapp.client.ui.login.LoginPlace;
import uz.javlon.webapp.client.ui.logout.LogoutActivity;
import uz.javlon.webapp.client.ui.logout.LogoutPlace;
import uz.javlon.webapp.client.ui.mainMenu.MainMenuActivity;
import uz.javlon.webapp.client.ui.mainMenu.MainMenuPlace;
import uz.javlon.webapp.client.ui.reloadOptions.ReloadOptionsActivity;
import uz.javlon.webapp.client.ui.reloadOptions.ReloadOptionsPlace;
import uz.javlon.webapp.client.ui.upload.FileUploadActivity;
import uz.javlon.webapp.client.ui.upload.FileUploadPlace;
import uz.javlon.webapp.client.ui.users.active.ActiveUsersActivity;
import uz.javlon.webapp.client.ui.users.active.ActiveUsersPlace;
import uz.javlon.webapp.client.ui.users.editProfile.EditProfileActivity;
import uz.javlon.webapp.client.ui.users.editProfile.EditProfilePlace;
import uz.javlon.webapp.client.ui.users.editUser.EditUserActivity;
import uz.javlon.webapp.client.ui.users.search.UsersSearchActivity;
import uz.javlon.webapp.client.ui.users.signUp.SignUpActivity;
import uz.javlon.webapp.client.ui.users.signUp.SignUpPlace;
import uz.javlon.webapp.client.ui.users.updatePassword.UpdatePasswordActivity;
import uz.javlon.webapp.client.ui.users.updatePassword.UpdatePasswordPlace;

/**
 * @author ivangsa
 */
public class ApplicationActivityMapper implements ActivityMapper {

    @Inject
    private Provider<MainMenuActivity> mainMenuActivityProvider;
    @Inject
    private Provider<LoginActivity> loginActivityProvider;
    @Inject
    private Provider<UpdatePasswordActivity> updatePasswordActivityProvider;
    @Inject
    private AsyncProvider<LogoutActivity> logoutActivityProvider;
    @Inject
    private AsyncProvider<ReloadOptionsActivity> reloadOptionsActivityProvider;
    @Inject
    private AsyncProvider<SignUpActivity> signUpActivityProvider;
    @Inject
    private AsyncProvider<EditProfileActivity> editProfileActivityProvider;
    @Inject
    private AsyncProvider<ActiveUsersActivity> activeUsersActivityProvider;
    @Inject
    private AsyncProvider<FileUploadActivity> fileUploadActivityProvider;
    @Inject
    private AsyncProvider<EditUserActivity> editUserActivityProvider;
    @Inject
    private AsyncProvider<UsersSearchActivity> usersSearchActivityProvider;


    @Override
    public Activity getActivity(final Place place) {
        Activity activity = null;

        if (place instanceof LoginPlace) {
            activity = this.loginActivityProvider.get();
        } else if (place instanceof MainMenuPlace) {
            activity = this.mainMenuActivityProvider.get();
        } else if (place instanceof UpdatePasswordPlace) {
            activity = this.updatePasswordActivityProvider.get();
        } else if (place instanceof LogoutPlace) {
            activity = new AsyncActivityProxy<LogoutActivity>(this.logoutActivityProvider);
        } else if (place instanceof SignUpPlace) {
            activity = new AsyncActivityProxy<SignUpActivity>(this.signUpActivityProvider);
        } else if (place instanceof EditProfilePlace) {
            activity = new AsyncActivityProxy<EditProfileActivity>(this.editProfileActivityProvider);
        } else if (place instanceof ActiveUsersPlace) {
            activity = new AsyncActivityProxy<ActiveUsersActivity>(this.activeUsersActivityProvider);
        } else if (place instanceof FileUploadPlace) {
            activity = new AsyncActivityProxy<FileUploadActivity>(this.fileUploadActivityProvider);
        } else if (place instanceof ReloadOptionsPlace) {
            activity = new AsyncActivityProxy<ReloadOptionsActivity>(this.reloadOptionsActivityProvider);
        } else if (place instanceof EntityProxyPlace) {
            final EntityProxyPlace proxyPlace = (EntityProxyPlace) place;
            if (UserProxy.class.equals(proxyPlace.getProxyClass())) {
                activity = new AsyncActivityProxy<EditUserActivity>(this.editUserActivityProvider);
            }
        } else if (place instanceof EntitySearchPlace) {
            final EntitySearchPlace listPlace = (EntitySearchPlace) place;
            if (UserProxy.class.equals(listPlace.getProxyClass())) {
                activity = new AsyncActivityProxy<UsersSearchActivity>(this.usersSearchActivityProvider);
            }
        }

        return activity;
    }

}
