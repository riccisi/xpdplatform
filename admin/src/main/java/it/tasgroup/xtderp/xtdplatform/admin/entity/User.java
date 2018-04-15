package it.tasgroup.xtderp.xtdplatform.admin.entity;

import it.tasgroup.xtderp.xtdplatform.core.jpa.BaseJpaEntity;
import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdExclude;
import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdMenu;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.cactoos.list.Joined;
import org.cactoos.list.ListOf;
import org.cactoos.list.Mapped;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
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
//@XtdFormLayout(columns = 2)
//@XtdModel
//@XtdLabel("{username}")
//@XtdDefaultTenant
//@UniqueUsernameValidator(groups = WhenTransient.class)
//@PasswordConfirmValidator(groups = WhenTransient.class)
public class User extends BaseJpaEntity implements UserDetails {

    private static final String[] STRINGS = new String[0];

    @Column(name = "RIF_ID")
//    @XtdColumnLayout(hidden = true)
//    @XtdFieldLayout(hidden = true)
    private String rifId;

    @Column(name = "USERNAME", updatable = false)
//    @XtdFieldLayout(order = ATTR_ORDER_USERNAME, span = 2)
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
//    @XtdFieldLayout(order = ATTR_ORDER_ACTIVE,  span = 2)
    private final boolean active = true;

    @Column(name = "START_DATE")
//    @XtdFieldLayout(order = ATTR_ORDER_START_DATE)
    private final Date startDate = new Date();

    @Column(name = "END_DATE")
//    @XtdFieldLayout(order = ATTR_ORDER_END_DATE)
    private Date endDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @XtdExclude
    @JoinTable(name = "XTD_UTN_ROLE", joinColumns = @JoinColumn(name = "ID_UTN", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID"))
    private List<Role> roles = new ArrayList<>();

    public User(String username, String password, String displayName, Role... roles) {
        this.username = username;
        this.displayName = displayName;
        this.password = password;
        this.roles = new ListOf<>(roles);
    }

    @PrePersist
    private void encodePassword() {
        this.password = new ShaPasswordEncoder(256).encodePassword(this.password, null);
    }

    public final List<String> permissions() {
        return new Joined<>(
            new Mapped<>(
                Role::permissions,
                this.roles
            )
        );
    }

    @Override
    public final Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(this.permissions().toArray(STRINGS));
    }

    @Override
    public final String getPassword() {
        return this.rifId != null ? this.rifId : this.password;
    }

    @Override
    public final String getUsername() {
        return this.username;
    }

    @Override
    public final boolean isAccountNonExpired() {
        return this.endDate == null || this.endDate.compareTo(new Date()) >= 0;
    }

    @Override
    public final boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public final boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public final boolean isEnabled() {
        return this.active && this.startDate.compareTo(new Date()) <= 0;
    }
}