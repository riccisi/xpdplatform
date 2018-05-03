package it.tasgroup.xtderp.xtdplatform.admin.security;

import it.tasgroup.xtderp.xtdplatform.admin.Role;
import it.tasgroup.xtderp.xtdplatform.admin.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cactoos.list.Mapped;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class XtdUserDetails implements UserDetails {

    private static final String[] ZERO_ARRAY = new String[0];
    private static final long serialVersionUID = -4488824481338286548L;

    @NonNull private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(
            new Mapped<>(
                Role::name,
                this.user.roles()
            ).toArray(ZERO_ARRAY)
        );
    }

    @Override
    public String getPassword() {
        return this.user.password();
    }

    @Override
    public String getUsername() {
        return this.user.userName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.user.endDate() == null || this.user.endDate().compareTo(new Date()) >= 0;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.active() && this.user.startDate().compareTo(new Date()) <= 0;
    }
}