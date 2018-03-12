package it.tasgroup.xtderp.xtdplatform.metadata.query.jpa;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.metadata.query.PagedCondition;
import it.tasgroup.xtderp.xtdplatform.metadata.query.PagedQueryAction;
import it.tasgroup.xtderp.xtdplatform.metadata.query.PagedQueryResult;
import it.tasgroup.xtderp.xtdplatform.metadata.query.QueryResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.io.Serializable;
import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class JpaPagedQueryAction<T> implements PagedQueryAction<T> {

    private final Class<T> modelClass;

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
    public QueryResult<T> execute(Request<PagedCondition> request) throws Exception {
        PagedCondition condition = request.value();
        JpaStatement<T> statement = new JpaStatement<>();
        condition.apply(statement);
        SimpleJpaRepository<T, Serializable> repository = new SimpleJpaRepository<>(modelClass, entityManager);
        PageRequest pageRequest =  new PageRequest(condition.page() - 1, condition.limit());
        Page<T> result = repository.findAll(statement.get(), pageRequest);
        return new PagedQueryResult<>(result.getContent(), result.getTotalPages());
    }

    @Override
    public void print(Media media) {
        media.with("id", this.id());
        media.with("type", "paged-query");
        media.with("modelId", this.modelId());
    }

    private String entityName() {
        return this.entityManager.getMetamodel().entity(this.modelClass).getName();
    }
}