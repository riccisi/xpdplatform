package it.tasgroup.xtderp.xtdplatform.admin.entity;

public class Role {}

/*import com.fasterxml.jackson.annotation.JsonAutoDetect;
import it.tasgroup.xtderp.extenderplib.core.metadata.annotation.XtdDefaultTenant;
import it.tasgroup.xtderp.extenderplib.core.metadata.annotation.XtdExclude;
import it.tasgroup.xtderp.extenderplib.core.metadata.annotation.XtdFieldLayout;
import it.tasgroup.xtderp.extenderplib.core.metadata.annotation.XtdLabel;
import it.tasgroup.xtderp.extenderplib.core.metadata.annotation.XtdModel;
import it.tasgroup.xtderp.extenderplib.core.metadata.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by borric on 18/11/2015.
 */
/*
@Entity
@Table(name="XTD_ROLE")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@XtdLabel("{description}")
@XtdModel
@XtdDefaultTenant
public class Role extends BaseEntity {

    public static final int ATTR_ORDER_COD = 1;
    public static final int ATTR_ORDER_DES = 2;

    @Column(name = "COD")
    @XtdFieldLayout(order = ATTR_ORDER_COD)
    private String cod;

    @Column(name = "DES")
    @XtdFieldLayout(order = ATTR_ORDER_DES)
    private String description;

    @ElementCollection
    @CollectionTable(name = "XTD_ROLE_ABL", joinColumns=@JoinColumn(name="ID_ROLE"))
    @XtdExclude
    private List<Permission> permissions;

    public List<String> permissionCodes() {
        List<String> permissionCodes = new ArrayList<>();
        for(Permission permission : permissions) {
            permissionCodes.add(permission.getCode());
        }
        return permissionCodes;
    }

    @Override
    public String toString() {
        return "Role{" +
            "idOf='" + getId() + '\'' +
            ", cod='" + cod + '\'' +
            ", description='" + description + '\'' +
            ", permissions=" + permissions +
            '}';
    }
}
*/
