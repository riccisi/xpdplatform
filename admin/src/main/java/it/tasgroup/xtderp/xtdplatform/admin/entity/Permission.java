package it.tasgroup.xtderp.xtdplatform.admin.entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * Created by borric on 18/11/2015.
 */
@Embeddable
@ToString
@EqualsAndHashCode(of = "code")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
//@XtdDefaultTenant
public class Permission {

    @Column(name = "COD")
    private String code;

    public Permission(final String code) {
        this.code = code;
    }

    public final String code() {
        return this.code;
    }
}