package uz.javlon.webapp.client.application;

import com.google.gwt.place.shared.PlaceHistoryMapperWithFactory;
import com.google.gwt.place.shared.WithTokenizers;
import uz.javlon.webapp.client.ui.login.LoginPlace;
import uz.javlon.webapp.client.ui.logout.LogoutPlace;
import uz.javlon.webapp.client.ui.mainMenu.MainMenuPlace;
import uz.javlon.webapp.client.ui.reloadOptions.ReloadOptionsPlace;
import uz.javlon.webapp.client.ui.upload.FileUploadPlace;
import uz.javlon.webapp.client.ui.users.active.ActiveUsersPlace;
import uz.javlon.webapp.client.ui.users.editProfile.EditProfilePlace;
import uz.javlon.webapp.client.ui.users.signUp.SignUpPlace;
import uz.javlon.webapp.client.ui.users.updatePassword.UpdatePasswordPlace;

@WithTokenizers({
        MainMenuPlace.Tokenizer.class,
        LoginPlace.Tokenizer.class,
        UpdatePasswordPlace.Tokenizer.class,
        LogoutPlace.Tokenizer.class,
        EditProfilePlace.Tokenizer.class,
        SignUpPlace.Tokenizer.class,
        ActiveUsersPlace.Tokenizer.class,
        FileUploadPlace.Tokenizer.class,
        ReloadOptionsPlace.Tokenizer.class
})
public interface ApplicationPlaceHistoryMapper extends PlaceHistoryMapperWithFactory<ApplicationPlaceHistoryFactory> {
}