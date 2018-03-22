package it.tasgroup.xtderp.xtdplatform.metadata.query.jpa;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import it.tasgroup.xtderp.xtdplatform.metadata.model.jpa.JpaEntity;
import it.tasgroup.xtderp.xtdplatform.metadata.query.FullQueryResult;
import it.tasgroup.xtderp.xtdplatform.metadata.query.QueryResult;
import it.tasgroup.xtderp.xtdplatform.metadata.query.request.FilterRequest;
import org.cactoos.collection.Mapped;
import org.cactoos.list.ListOf;

import javax.persistence.EntityManager;

/**
 * JPA implementation
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class JpaFullQuery<T> extends JpaQuery<T> {

    public JpaFullQuery(Class<T> entityClass, EntityManager entityManager) {
        super(entityManager, entityClass);
    }

    @Override
    public QueryResult find(Request request) throws Exception {
        JpaStatement<T> statement = new JpaStatement<>();
        new FilterRequest(request).filter().applyOn(statement);
        return
            new FullQueryResult(
                new ListOf<>(
                    new Mapped<>(
                        o -> new JpaEntity<>(o, this.metadata, entityManager),
                        this.repository.findAll(statement.get())
                    )
                )
            );
    }

}