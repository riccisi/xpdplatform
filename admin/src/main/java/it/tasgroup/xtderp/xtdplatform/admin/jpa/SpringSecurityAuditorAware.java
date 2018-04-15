package it.tasgroup.xtderp.xtdplatform.admin.jpa;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Created by ricciardis on 27/01/2016.
 */
@Component
public final class SpringSecurityAuditorAware implements AuditorAware<String> {

    private static final String ANONYMOUS = "anonymous";

    @Override
    public String getCurrentAuditor() {
        final String auditor;
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            auditor = ANONYMOUS;
        } else {
            auditor = ((UserDetails) authentication.getPrincipal()).getUsername();
        }
        return auditor;
    }
}