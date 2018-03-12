package it.tasgroup.xtderp.xtdplatform.security.entity;

public class User {}

/*import com.fasterxml.jackson.annotation.JsonAutoDetect;
import it.tasgroup.xtderp.extenderplib.admin.model.strategy.PasswordManagementFieldStatusStrategy;
import it.tasgroup.xtderp.extenderplib.admin.model.validation.PasswordConfirmValidator;
import it.tasgroup.xtderp.extenderplib.admin.model.validation.UniqueUsernameValidator;
import it.tasgroup.xtderp.extenderplib.infrastructure.model.*;
import it.tasgroup.xtderp.extenderplib.infrastructure.model.annotation.*;
import it.tasgroup.xtderp.extenderplib.infrastructure.model.BaseEntity;
import it.tasgroup.xtderp.extenderplib.infrastructure.validation.WhenTransient;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.Size;

/**
 * Created by borric on 18/11/2015.
 */
/*@Entity
@Table(name = "XTD_UTN")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@XtdFormLayout(columns = 2)
@XtdModel
@XtdLabel("{username}")
@XtdDefaultTenant
@UniqueUsernameValidator(groups = WhenTransient.class)
@PasswordConfirmValidator(groups = WhenTransient.class)
public class User extends BaseEntity {

    public static final int ATTR_ORDER_USERNAME = 1;
    public static final int ATTR_ORDER_DISPLAY_NAME = 2;
    private static final int ATTR_ORDER_PASSWORD = 3;
    public static final int ATTR_ORDER_CONFIRM_PASSWORD = 4;
    public static final int ATTR_ORDER_ACTIVE = 5;
    public static final int ATTR_ORDER_START_DATE = 6;
    public static final int ATTR_ORDER_END_DATE = 7;

    @Column(name = "RIF_ID")
    @XtdColumnLayout(hidden = true)
    @XtdFieldLayout(hidden = true)
    private String rifId;

    @Column(name = "USERNAME", updatable = false)
    @XtdFieldLayout(order = ATTR_ORDER_USERNAME, span = 2)
    @NotBlank
    @Size(max = 100)
    private String username;

    @Column(name = "DISPLAY_NAME")
    @XtdFieldLayout(order = ATTR_ORDER_DISPLAY_NAME, span = 2)
    @Size(max = 240)
    private String displayName;

    @Column(name = "PASSWORD", updatable = false)
    @XtdFieldLayout(order = ATTR_ORDER_PASSWORD, fieldStatusStrategy = PasswordManagementFieldStatusStrategy.class)
    @XtdColumnLayout(hidden = true, exportable = true)
    @XtdField(type = FieldType.PASSWORD)
    @NotBlank(groups = WhenTransient.class)
    @Size(min = 8)
    private String password;

    @Transient
    @XtdFieldLayout(order = ATTR_ORDER_CONFIRM_PASSWORD, fieldStatusStrategy = PasswordManagementFieldStatusStrategy.class)
    @XtdColumnLayout(hidden = true, exportable = false)
    @XtdField(type = FieldType.PASSWORD)
    @NotBlank(groups = WhenTransient.class)
    @Size(min = 8)
    private String passwordConfirm;

    @Column(name = "ACTIVE")
    @XtdFieldLayout(order = ATTR_ORDER_ACTIVE,  span = 2)
    private boolean active = true;

    @Column(name = "START_DATE")
    @XtdFieldLayout(order = ATTR_ORDER_START_DATE)
    private Date startDate = new Date();

    @Column(name = "END_DATE")
    @XtdFieldLayout(order = ATTR_ORDER_END_DATE)
    private Date endDate;

    @ManyToMany
    @XtdExclude
    @JoinTable(
        name="XTD_UTN_ROLE",
        joinColumns={@JoinColumn(name="ID_UTN", referencedColumnName="ID")},
        inverseJoinColumns={@JoinColumn(name="ID_ROLE", referencedColumnName="ID")})
    private List<Role> roles = new ArrayList<>();

    public String getRifId() {
        return rifId;
    }

    public void setRifId(String rifId) {
        this.rifId = rifId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @PrePersist
    private void encodePassword() {
        this.password = new BCryptPasswordEncoder().encode(this.password);
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public boolean hasRoles() {
        return this.roles.size() > 0;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public Collection<String> allPermissionCodes() {
        Set<String> permissionCodes = new HashSet<>();
        for(Role role : roles) {
            permissionCodes.addAll(role.permissionCodes());
        }
        return permissionCodes;
    }
}*/
