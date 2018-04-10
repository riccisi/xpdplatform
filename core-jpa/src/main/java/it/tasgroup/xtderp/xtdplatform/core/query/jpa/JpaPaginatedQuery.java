package it.tasgroup.xtderp.xtdplatform.core.query.jpa;

import it.tasgroup.xtderp.xtdplatform.core.action.Request;
import it.tasgroup.xtderp.xtdplatform.core.metadata.jpa.JpaEntity;
import it.tasgroup.xtderp.xtdplatform.core.query.PageQueryResult;
import it.tasgroup.xtderp.xtdplatform.core.query.QueryResult;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.PaginatedFilter;
import it.tasgroup.xtderp.xtdplatform.core.query.request.PaginatedFilterRequest;
import org.cactoos.collection.Mapped;
import org.cactoos.list.ListOf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public final class JpaPaginatedQuery<T> extends JpaQuery<T> {

    public JpaPaginatedQuery(final Class<T> entityClass, final EntityManager entityManager) {
        super(entityManager, entityClass);
    }

    @Override
    public QueryResult find(final Request request) throws Exception {
        final JpaStatement<T> statement = new JpaStatement<>();
        final PaginatedFilter condition = new PaginatedFilterRequest(request).filter();
        condition.applyOn(statement);
        final PageRequest pageRequest = new PageRequest(condition.page() - 1, condition.limit());
        final Page<T> result = this.repository.findAll(statement.get(), pageRequest);
        return
            new PageQueryResult(
                new ListOf<>(
                    new Mapped<>(
                        o -> new JpaEntity<>(o, this.metadata, this.entityManager),
                        result.getContent()
                    )
                ),
                result.getTotalElements()
            );
    }
}