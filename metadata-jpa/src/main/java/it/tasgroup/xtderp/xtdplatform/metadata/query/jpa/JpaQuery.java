package it.tasgroup.xtderp.xtdplatform.metadata.query.jpa;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.PrintableCollection;
import it.tasgroup.xtderp.xtdplatform.metadata.model.EntityMetadata;
import it.tasgroup.xtderp.xtdplatform.metadata.model.jpa.JpaEntity;
import it.tasgroup.xtderp.xtdplatform.metadata.model.jpa.JpaEntityMetadata;
import it.tasgroup.xtderp.xtdplatform.metadata.query.Condition;
import it.tasgroup.xtderp.xtdplatform.metadata.query.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * JPA implementation
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class JpaQuery<T> implements Query {

    private final EntityManager entityManager;
    private final Class<T> entityClass;
    private final EntityMetadata<T> metadata;
    private final SimpleJpaRepository<T, Serializable> repository;

    public JpaQuery(Class<T> entityClass, EntityManager entityManager) {
        this.entityClass = entityClass;
        this.entityManager = entityManager;
        this.metadata = new JpaEntityMetadata<>(entityManager, entityClass);
        this.repository = new SimpleJpaRepository<>(entityClass, entityManager);
    }

    @Override
    public String id() {
        return String.format("find%s",this.entityName());
    }

    @Override
    public String modelId() {
        return this.entityName();
    }

    @Override
    public PrintableCollection find(Condition condition) {
        JpaStatement<T> statement = new JpaStatement<>();
        condition.apply(statement);
        return new PrintableCollection(repository.findAll(statement.get()), o -> new JpaEntity<T>(o, this.metadata, entityManager));
    }

    @Override
    public Printable find(Condition condition, int page, int limit) {
        JpaStatement<T> statement = new JpaStatement<>();
        condition.apply(statement);
        PageRequest pageRequest =  new PageRequest(page - 1, limit);
        Page<T> result = repository.findAll(statement.get(), pageRequest);
        return new JpaPagedResult<T>(result, this.metadata, this.entityManager);
    }

    private String entityName() {
        return this.entityManager.getMetamodel().entity(this.entityClass).getName();
    }
}
