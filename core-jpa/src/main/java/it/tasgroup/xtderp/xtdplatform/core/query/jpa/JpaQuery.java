package it.tasgroup.xtderp.xtdplatform.core.query.jpa;

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

    public JpaQuery(EntityManager entityManager, Class<T> entityClass) {
        this.metadata = new JpaEntityMetadata<>(entityManager, entityClass);
        this.entityManager = entityManager;
        this.entityClass = entityClass;
        this.repository = new SimpleJpaRepository<>(entityClass, entityManager);
    }

    @Override
    public final String id() throws Exception {
        return String.format("find%s", this.modelId());
    }

    @Override
    public final String modelId() throws Exception {
        return this.metadata.id();
    }
}