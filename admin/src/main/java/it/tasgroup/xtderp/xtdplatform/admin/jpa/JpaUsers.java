package it.tasgroup.xtderp.xtdplatform.admin.jpa;

import it.tasgroup.xtderp.xtdplatform.admin.Users;
import it.tasgroup.xtderp.xtdplatform.admin.entity.JpaUser;
import it.tasgroup.xtderp.xtdplatform.admin.repository.UserRepository;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class JpaUsers implements Users {

    private final UserRepository repository;

    @Override
    public JpaUser byUserName(final String username) {
        return this.repository.findByUsername(username);
    }
}