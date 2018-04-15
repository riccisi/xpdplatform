package it.tasgroup.xtderp.xtdplatform.core.jpa;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by ricciardis on 28/04/2016.
 */
@MappedSuperclass
public abstract class BaseJpaEntity implements Versionable {

    @Id
    @GeneratedValue(generator = "assigned")
    @GenericGenerator(name = "assigned", strategy = "it.tasgroup.xtderp.xtdplatform.core.jpa.AssignedGenerator")
    @Column(name = "ID", columnDefinition = "CHAR(32)")
    private String id;

    @Version
    @Column(name = "VERSION")
    private Long version;

    @Override
    public final Long version() {
        return this.version;
    }

    public String id() {
        return this.id;
    }

    public boolean isTransient() {
        return this.id == null || this.id.startsWith(this.getClass().getName());
    }

}