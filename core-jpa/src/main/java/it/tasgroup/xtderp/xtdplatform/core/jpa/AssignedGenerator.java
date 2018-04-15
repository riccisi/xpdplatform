package it.tasgroup.xtderp.xtdplatform.core.jpa;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.UUIDHexGenerator;

import java.io.Serializable;

/**
 *
 */
public final class AssignedGenerator extends UUIDHexGenerator {

    /**
     * @param session
     * @param object
     * @return
     * @throws HibernateException
     */
    @SuppressWarnings({"CastToConcreteClass", "InstanceofConcreteClass"})
    @Override
    public Serializable generate(final SessionImplementor session, final Object object) {
        Serializable id = super.generate(session, object);
        if(object instanceof BaseJpaEntity) {
            final BaseJpaEntity entity = (BaseJpaEntity) object;
            if (!entity.isTransient()) {
                id = entity.id();
            }
        }
        return id;
    }
}