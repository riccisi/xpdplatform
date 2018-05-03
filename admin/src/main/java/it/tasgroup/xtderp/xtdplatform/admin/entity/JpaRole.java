package it.tasgroup.xtderp.xtdplatform.admin.entity;

import it.tasgroup.xtderp.xtdplatform.admin.Role;
import it.tasgroup.xtderp.xtdplatform.core.jpa.BaseJpaEntity;
import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdExclude;
import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdMenu;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.cactoos.list.ListOf;

import javax.persistence.*;
import java.util.List;

/**
 * Created by borric on 18/11/2015.
 */
@Entity
@Table(name="XTD_ROLE")
@ToString
@EqualsAndHashCode(of = "code", callSuper = false)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@XtdMenu("admin.security.roles")
//@XtdLabel("{description}")
//@XtdModel
//@XtdDefaultTenant
public class JpaRole extends BaseJpaEntity implements Role {

    private static final long serialVersionUID = 6364795256501522298L;

    @Column(name = "COD")
    private String code;

    @Column(name = "DES")
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "XTD_ROLE_ABL", joinColumns=@JoinColumn(name="ID_ROLE"))
    @XtdExclude
    private List<Permission> permissions;

    public JpaRole(final String code, Permission... permissions) {
        this.code = code;
        this.permissions = new ListOf<>(permissions);
    }

    @Override
    public String name() {
        return this.code;
    }
}