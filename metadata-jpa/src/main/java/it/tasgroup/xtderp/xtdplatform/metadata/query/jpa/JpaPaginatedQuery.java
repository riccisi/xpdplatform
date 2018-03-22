package it.tasgroup.xtderp.xtdplatform.metadata.query.jpa;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import it.tasgroup.xtderp.xtdplatform.metadata.model.jpa.JpaEntity;
import it.tasgroup.xtderp.xtdplatform.metadata.query.PageQueryResult;
import it.tasgroup.xtderp.xtdplatform.metadata.query.filter.PaginatedFilter;
import it.tasgroup.xtderp.xtdplatform.metadata.query.QueryResult;
import it.tasgroup.xtderp.xtdplatform.metadata.query.request.PaginatedFilterRequest;
import org.cactoos.collection.Mapped;
import org.cactoos.list.ListOf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class JpaPaginatedQuery<T> extends JpaQuery<T> {

    public JpaPaginatedQuery(Class<T> entityClass, EntityManager entityManager) {
        super(entityManager, entityClass);
    }

    @Override
    public QueryResult find(Request request) throws Exception {
        JpaStatement<T> statement = new JpaStatement<>();
        PaginatedFilter condition = new PaginatedFilterRequest(request).filter();
        condition.applyOn(statement);
        PageRequest pageRequest = new PageRequest(condition.page() - 1, condition.limit());
        Page<T> result = repository.findAll(statement.get(), pageRequest);
        return
            new PageQueryResult(
                new ListOf<>(
                    new Mapped<>(
                        o -> new JpaEntity<>(o, this.metadata, entityManager),
                        result.getContent()
                    )
                ),
                result.getTotalElements()
            );
    }
}