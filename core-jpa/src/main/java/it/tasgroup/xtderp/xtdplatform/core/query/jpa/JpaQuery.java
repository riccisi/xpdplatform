package it.tasgroup.xtderp.xtdplatform.core.query.jpa;

import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import it.tasgroup.xtderp.xtdplatform.core.metadata.EntityMetadata;
import it.tasgroup.xtderp.xtdplatform.core.metadata.jpa.JpaEntityMetadata;
import it.tasgroup.xtderp.xtdplatform.core.query.Query;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
abstract class JpaQuery<T> implements Query {

    protected final EntityManager entityManager;
    protected final Class<T> entityClass;
    protected final EntityMetadata<T> metadata;
    protected final SimpleJpaRepository<T, Serializable> repository;

    protected JpaQuery(final EntityManager entityManager, final Class<T> entityClass, final I18n i18n) {
        this.metadata = new JpaEntityMetadata<>(entityManager, entityClass, i18n);
        this.entityManager = entityManager;
        this.entityClass = entityClass;
        this.repository = new SimpleJpaRepository<>(entityClass, entityManager);
    }

    @Override
    public final String id() {
        return String.format("find%s", this.modelId());
    }

    @Override
    public final String modelId() {
        return this.metadata.id();
    }
}