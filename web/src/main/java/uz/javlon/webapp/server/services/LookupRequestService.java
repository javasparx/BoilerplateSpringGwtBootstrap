package uz.javlon.webapp.server.services;

import org.springframework.security.access.annotation.Secured;
import uz.javlon.model.LabelValue;
import uz.javlon.model.Role;
import uz.javlon.webapp.client.proxies.LookupConstantsProxy;

import java.util.ArrayList;
import java.util.List;

public interface LookupRequestService {

    /**
     * Application wide constants to be sent to the client.
     *
     * @see LookupConstantsProxy
     */
    public static class LookupConstants {

        private List<Role> availableRoles = new ArrayList<Role>();
        private List<LabelValue> countries = new ArrayList<LabelValue>();

        public List<Role> getAvailableRoles() {
            return availableRoles;
        }

        public void setAvailableRoles(List<Role> availableRoles) {
            this.availableRoles = availableRoles;
        }

        public List<LabelValue> getCountries() {
            return countries;
        }

        public void setCountries(List<LabelValue> countries) {
            this.countries = countries;
        }

    }

    /**
     * @return
     */
    LookupConstants getApplicationConstants();

    /**
     * @return
     */
    @Secured("ROLE_ADMIN")
    LookupConstants reloadOptions();

}