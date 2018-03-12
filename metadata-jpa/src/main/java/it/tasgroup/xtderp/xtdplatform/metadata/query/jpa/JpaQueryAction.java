package it.tasgroup.xtderp.xtdplatform.metadata.query.jpa;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.metadata.query.Condition;
import it.tasgroup.xtderp.xtdplatform.metadata.query.ListQueryResult;
import it.tasgroup.xtderp.xtdplatform.metadata.query.QueryAction;
import it.tasgroup.xtderp.xtdplatform.metadata.query.QueryResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 * <code>QueryAction</code> implementing a query execution through JPA technology.
 * JPA is not directly used, but Spring Data is used instead.
 *
 * @param <T>
 */
@RequiredArgsConstructor
public final class JpaQueryAction<T> implements QueryAction<T> {

    private final Class<T> entityClass;

    private final EntityManager entityManager;

    @Override
    public String id() {
        return String.format("find%s",this.entityName());
    }

    @Override
    public String modelId() {
        return this.entityName();
    }

    @Override
    public QueryResult<T> execute(Request<Condition> request) throws Exception {
        JpaStatement<T> statement = new JpaStatement<>();
        request.value().apply(statement);
        SimpleJpaRepository<T, Serializable> repository = new SimpleJpaRepository<>(entityClass, entityManager);
        return new ListQueryResult<>(repository.findAll(statement.get()));
    }

    @Override
    public void print(Media media) {
        media.with("id", this.id());
        media.with("type", "query");
        media.with("modelId", this.modelId());
    }

    private String entityName() {
        return this.entityManager.getMetamodel().entity(this.entityClass).getName();
    }
}