package it.tasgroup.xtderp.xtdplatform.admin.security;

import it.tasgroup.xtderp.xtdplatform.admin.User;
import it.tasgroup.xtderp.xtdplatform.admin.Users;
import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ricciardis on 22/01/2016.
 */
@RequiredArgsConstructor
@SuppressWarnings("DesignForExtension")
public class XtdUserDetailService implements UserDetailsService {

    @NonNull private final Users users;
    @NonNull private final I18n i18n;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) {
        final User user = this.users.byUserName(username);
        if(user == null) {
            final String message = this.i18n.text("UserDetailService.usernameNotFound", new String[]{username});
            throw new UsernameNotFoundException(message);
        }
        return new XtdUserDetails(user);
    }
}