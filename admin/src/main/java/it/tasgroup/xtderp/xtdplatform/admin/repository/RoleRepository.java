package it.tasgroup.xtderp.xtdplatform.admin.repository;

import it.tasgroup.xtderp.xtdplatform.admin.entity.JpaRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@SuppressWarnings("InterfaceNeverImplemented")
public interface RoleRepository extends JpaRepository<JpaRole, String>, JpaSpecificationExecutor<JpaRole> {

    JpaRole findByCode(String code);
}
