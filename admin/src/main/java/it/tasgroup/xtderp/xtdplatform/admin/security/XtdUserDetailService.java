package it.tasgroup.xtderp.xtdplatform.admin.security;

import it.tasgroup.xtderp.xtdplatform.admin.entity.User;
import it.tasgroup.xtderp.xtdplatform.admin.repository.UserRepository;
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

    @NonNull private final UserRepository repository;
    @NonNull private final I18n i18n;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) {
        final User user = this.repository.findByUsername(username);
        if(user == null) {
            final String message = this.i18n.text("UserDetailService.usernameNotFound", new String[]{username});
            throw new UsernameNotFoundException(message);
        }
        return user;
    }
}