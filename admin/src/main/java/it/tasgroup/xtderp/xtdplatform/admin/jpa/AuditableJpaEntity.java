package it.tasgroup.xtderp.xtdplatform.admin.jpa;

import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdExclude;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

//import org.javers.core.metamodel.annotation.DiffIgnore;

/**
 * AuditingEntityListener will also audit any subclasses of AbstractAuditable.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableJpaEntity {
	
	@CreatedDate
    @Column(name = "DATA_ISR")
    @XtdExclude
    //@DiffIgnore
/*
    @AttributeMetadata(hiddenInGrid = true, fieldStatusStrategy = HiddenFieldStatusStrategy.class)
    @XtdField(type = FieldType.DATETIME, exportable = false)
*/
    private Date insertionDate;
	
	@CreatedBy
    @Column(name = "WHO_ISR")
    @XtdExclude
    //@DiffIgnore
/*
    @AttributeMetadata(hiddenInGrid = true, fieldStatusStrategy = HiddenFieldStatusStrategy.class)
    @XtdField(exportable = false)
*/
    private String whoInserted;
	
	@LastModifiedDate
    @Column(name = "DATA_UPD")
    @XtdExclude
//    @DiffIgnore
/*
    @AttributeMetadata(hiddenInGrid = true, fieldStatusStrategy = HiddenFieldStatusStrategy.class)
    @XtdField(type = FieldType.DATETIME, exportable = false)
*/
    private Date updateDate;
	
	@LastModifiedBy
    @Column(name = "WHO_UPD")
    @XtdExclude
//    @DiffIgnore
/*
    @AttributeMetadata(hiddenInGrid = true, fieldStatusStrategy = HiddenFieldStatusStrategy.class)
    @XtdField(exportable = false)
*/
    private String whoUpdated;
}
