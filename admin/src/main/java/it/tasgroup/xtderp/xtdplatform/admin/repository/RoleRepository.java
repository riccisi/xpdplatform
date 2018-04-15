package it.tasgroup.xtderp.xtdplatform.admin.repository;

import it.tasgroup.xtderp.xtdplatform.admin.entity.Role;
import it.tasgroup.xtderp.xtdplatform.admin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@SuppressWarnings("InterfaceNeverImplemented")
public interface RoleRepository extends JpaRepository<Role, String>, JpaSpecificationExecutor<User> {

    Role findByCode(String code);
}
