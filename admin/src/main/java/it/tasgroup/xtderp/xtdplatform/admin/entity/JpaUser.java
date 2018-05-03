package it.tasgroup.xtderp.xtdplatform.admin.entity;

import it.tasgroup.xtderp.xtdplatform.admin.Role;
import it.tasgroup.xtderp.xtdplatform.admin.User;
import it.tasgroup.xtderp.xtdplatform.core.jpa.BaseJpaEntity;
import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdExclude;
import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdMenu;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.cactoos.list.ListOf;
import org.cactoos.list.Mapped;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by borric on 18/11/2015.
 */
@Entity
@Table(name = "XTD_UTN")
@ToString
@EqualsAndHashCode(of = "username", callSuper = false)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@XtdMenu("admin.security.users")
//@XtdModel
//@XtdLabel("{username}")
//@XtdDefaultTenant
//@UniqueUsernameValidator(groups = WhenTransient.class)
//@PasswordConfirmValidator(groups = WhenTransient.class)
public class JpaUser extends BaseJpaEntity implements User {

    private static final long serialVersionUID = -8757854285339390651L;

    @Column(name = "RIF_ID")
//    @XtdColumnLayout(hidden = true)
//    @XtdFieldLayout(hidden = true)
    private String rifId;

    @Column(name = "USERNAME", updatable = false)
    @NotBlank
    @Size(max = 100)
    private String username;

    @Column(name = "DISPLAY_NAME")
//    @XtdFieldLayout(order = ATTR_ORDER_DISPLAY_NAME, span = 2)
    @Size(max = 240)
    private String displayName;

    @Column(name = "PASSWORD", updatable = false)
//    @XtdFieldLayout(order = ATTR_ORDER_PASSWORD, fieldStatusStrategy = PasswordManagementFieldStatusStrategy.class)
//    @XtdColumnLayout(hidden = true, exportable = true)
//    @XtdField(type = FieldType.PASSWORD)
//    @NotBlank(groups = WhenTransient.class)
    @Size(min = 8)
    private String password;

    @Transient
//    @XtdFieldLayout(order = ATTR_ORDER_CONFIRM_PASSWORD, fieldStatusStrategy = PasswordManagementFieldStatusStrategy.class)
//    @XtdColumnLayout(hidden = true, exportable = false)
//    @XtdField(type = FieldType.PASSWORD)
//    @NotBlank(groups = WhenTransient.class)
    @Size(min = 8)
    private String passwordConfirm;

    @Column(name = "ACTIVE")
    private final boolean active = true;

    @Column(name = "START_DATE")
    private final Date startDate = new Date();

    @Column(name = "END_DATE")
    private Date endDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @XtdExclude
    @JoinTable(name = "XTD_UTN_ROLE", joinColumns = @JoinColumn(name = "ID_UTN", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID"))
    private List<JpaRole> roles = new ArrayList<>();

    public JpaUser(final String username, final String password, final String displayName, final JpaRole... roles) {
        this.username = username;
        this.displayName = displayName;
        this.password = password;
        this.roles = new ListOf<>(roles);
    }

    @PrePersist
    private void encodePassword() {
        this.password = new ShaPasswordEncoder(256).encodePassword(this.password, null);
    }

    @Override
    public final String userName() {
        return this.username;
    }

    @Override
    public final String password() {
        return this.password;
    }

    @Override
    public final String displayName() {
        return this.displayName;
    }

    @Override
    public final Date startDate() {
        return new Date(this.startDate.getTime());
    }

    @Override
    public final Date endDate() {
        return this.endDate != null ? new Date(this.endDate.getTime()) : null;
    }

    @Override
    public final boolean active() {
        return this.active;
    }

    @Override
    public final List<Role> roles() {
        return new Mapped<>(
            role -> role,
            this.roles
        );
    }
}