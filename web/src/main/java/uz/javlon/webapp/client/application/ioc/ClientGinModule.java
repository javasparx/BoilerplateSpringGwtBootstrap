package uz.javlon.webapp.client.application.ioc;


import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import uz.javlon.webapp.client.application.*;
import uz.javlon.webapp.client.application.base.request.EventSourceRequestTransport;
import uz.javlon.webapp.client.requests.ApplicationRequestFactory;
import uz.javlon.webapp.client.ui.login.LoginActivity;
import uz.javlon.webapp.client.ui.login.LoginView;
import uz.javlon.webapp.client.ui.login.LoginViewImpl;
import uz.javlon.webapp.client.ui.logout.LogoutActivity;
import uz.javlon.webapp.client.ui.mainMenu.MainMenuActivity;
import uz.javlon.webapp.client.ui.mainMenu.MainMenuView;
import uz.javlon.webapp.client.ui.mainMenu.MainMenuViewDesktop;
import uz.javlon.webapp.client.ui.reloadOptions.ReloadOptionsActivity;
import uz.javlon.webapp.client.ui.upload.FileUploadActivity;
import uz.javlon.webapp.client.ui.upload.views.FileUploadView;
import uz.javlon.webapp.client.ui.upload.views.FileUploadViewImpl;
import uz.javlon.webapp.client.ui.upload.views.UploadedFileView;
import uz.javlon.webapp.client.ui.upload.views.UploadedFileViewImpl;
import uz.javlon.webapp.client.ui.users.active.ActiveUsersActivity;
import uz.javlon.webapp.client.ui.users.active.ActiveUsersView;
import uz.javlon.webapp.client.ui.users.active.ActiveUsersViewImpl;
import uz.javlon.webapp.client.ui.users.editProfile.EditProfileActivity;
import uz.javlon.webapp.client.ui.users.editProfile.EditProfileView;
import uz.javlon.webapp.client.ui.users.editProfile.EditProfileViewImpl;
import uz.javlon.webapp.client.ui.users.editUser.EditUserActivity;
import uz.javlon.webapp.client.ui.users.editUser.EditUserView;
import uz.javlon.webapp.client.ui.users.editUser.EditUserViewImpl;
import uz.javlon.webapp.client.ui.users.search.UsersSearchActivity;
import uz.javlon.webapp.client.ui.users.search.UsersSearchView;
import uz.javlon.webapp.client.ui.users.search.UsersSearchViewImpl;
import uz.javlon.webapp.client.ui.users.signUp.SignUpActivity;
import uz.javlon.webapp.client.ui.users.signUp.SignUpView;
import uz.javlon.webapp.client.ui.users.signUp.SignUpViewImpl;
import uz.javlon.webapp.client.ui.users.updatePassword.UpdatePasswordView;
import uz.javlon.webapp.client.ui.users.updatePassword.UpdatePasswordViewImpl;


public class ClientGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(Application.class).to(DesktopApplication.class).in(Singleton.class);
        bind(ActivityMapper.class).to(ApplicationActivityMapper.class).in(Singleton.class);

        bind(MainMenuActivity.class);
        bind(LoginActivity.class);
        bind(LogoutActivity.class);
        bind(ReloadOptionsActivity.class);
        bind(SignUpActivity.class);
        bind(EditProfileActivity.class);
        bind(ActiveUsersActivity.class);
        bind(FileUploadActivity.class);
        bind(EditUserActivity.class);
        bind(UsersSearchActivity.class);

        bind(MainMenuView.class).to(MainMenuViewDesktop.class).in(Singleton.class);
        bind(LoginView.class).to(LoginViewImpl.class).in(Singleton.class);
        bind(UpdatePasswordView.class).to(UpdatePasswordViewImpl.class).in(Singleton.class);
        bind(SignUpView.class).to(SignUpViewImpl.class).in(Singleton.class);
        bind(EditProfileView.class).to(EditProfileViewImpl.class).in(Singleton.class);
        bind(ActiveUsersView.class).to(ActiveUsersViewImpl.class).in(Singleton.class);
        bind(FileUploadView.class).to(FileUploadViewImpl.class).in(Singleton.class);
        bind(UploadedFileView.class).to(UploadedFileViewImpl.class).in(Singleton.class);
        bind(EditUserView.class).to(EditUserViewImpl.class).in(Singleton.class);
        bind(UsersSearchView.class).to(UsersSearchViewImpl.class).in(Singleton.class);
    }


    @Provides
    @Singleton
    public PlaceController providePlaceController(final EventBus eventBus) {
        final PlaceController placeController = new PlaceController(eventBus);
        return placeController;
    }

    @Provides
    @Singleton
    public ApplicationRequestFactory provideRequestFactory(final EventBus eventBus) {
        final ApplicationRequestFactory requestFactory = GWT.create(ApplicationRequestFactory.class);
        requestFactory.initialize(eventBus, new EventSourceRequestTransport(eventBus));
        return requestFactory;
    }

    @Provides
    @Singleton
    PlaceHistoryMapper providePlaceHistoryMapper(final ApplicationRequestFactory requestFactory, final ApplicationProxyFactory proxyFactory) {
        final ApplicationPlaceHistoryMapper historyMapper = GWT.create(ApplicationPlaceHistoryMapper.class);
        historyMapper.setFactory(new ApplicationPlaceHistoryFactory(requestFactory, proxyFactory));
        return historyMapper;
    }

    @Provides
    @Singleton
    PlaceHistoryHandler providePlaceHistoryHandler(final PlaceHistoryMapper historyMapper) {
        return new PlaceHistoryHandler(historyMapper);
    }

    @Provides
    @Singleton
    ActivityManager provideActivityManager(final ActivityMapper activityMapper, final EventBus eventBus) {
        return new ActivityManager(activityMapper, eventBus);
    }
}
