package uz.javlon.webapp.client.requests;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import uz.javlon.webapp.client.proxies.UserProxy;
import uz.javlon.webapp.client.proxies.UsersSearchCriteriaProxy;
import uz.javlon.webapp.server.GwtServiceLocator;
import uz.javlon.webapp.server.services.UserRequestService;

import java.util.List;

@Service(value = UserRequestService.class, locator = GwtServiceLocator.class)
public interface UserRequest extends RequestContext {

    abstract Request<UserProxy> getCurrentUser();

    abstract Request<UserProxy> signUp();

    abstract Request<UserProxy> signUp(UserProxy user);

    abstract Request<UserProxy> editProfile();

    abstract Request<UserProxy> editProfile(UserProxy user);

    abstract Request<UserProxy> getUser(Long userId);

    abstract Request<UserProxy> saveUser(UserProxy user);

    abstract Request<Long> countUsers(UsersSearchCriteriaProxy searchCriteria);

    abstract Request<List<UserProxy>> searchUsers(UsersSearchCriteriaProxy searchCriteria, int firstResult, int maxResults);

    abstract Request<List<UserProxy>> searchUsers(UsersSearchCriteriaProxy searchCriteria, int firstResult, int maxResults, String sortProperty, boolean ascending);

    abstract Request<Void> removeUser(Long userId);

    abstract Request<String> sendPasswordHint(String username);

    abstract Request<String> requestRecoveryToken(String username);

    abstract Request<UserProxy> updatePassword(String username, String token, String currentPassword, String password);

    abstract Request<List<UserProxy>> getActiveUsers();

    abstract Request<Boolean> logout();

}
