package it.tasgroup.xtderp.xtdplatform.admin.entity;

import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdExclude;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

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
//@XtdFormLayout(columns = 2)
//@XtdModel
//@XtdLabel("{username}")
//@XtdDefaultTenant
//@UniqueUsernameValidator(groups = WhenTransient.class)
//@PasswordConfirmValidator(groups = WhenTransient.class)
public class User /*extends BaseEntity*/ {

    @Id
/*
    @GeneratedValue(generator = "assigned")
    @GenericGenerator(name = "assigned", strategy = "it.tasgroup.xtderp.extenderplib.core.model.AssignedGenerator")
    @Column(name = "ID", columnDefinition = "CHAR(32)")
*/
//    @XtdExclude
    private String id;

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
    private boolean active = true;

    @Column(name = "START_DATE")
//    @XtdFieldLayout(order = ATTR_ORDER_START_DATE)
    private Date startDate = new Date();

    @Column(name = "END_DATE")
//    @XtdFieldLayout(order = ATTR_ORDER_END_DATE)
    private Date endDate;

/*
    @ManyToMany
    @XtdExclude
    @JoinTable(
        name="XTD_UTN_ROLE",
        joinColumns={@JoinColumn(name="ID_UTN", referencedColumnName="ID")},
        inverseJoinColumns={@JoinColumn(name="ID_ROLE", referencedColumnName="ID")})
    private List<Role> roles = new ArrayList<>();
*/

/*
    @PrePersist
    private void encodePassword() {
        this.password = new BCryptPasswordEncoder().encode(this.password);
    }
*/

}