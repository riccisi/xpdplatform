package it.tasgroup.xtderp.xtdplatform.core.query.jpa;

import it.tasgroup.xtderp.xtdplatform.core.action.Request;
import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import it.tasgroup.xtderp.xtdplatform.core.metadata.jpa.JpaEntity;
import it.tasgroup.xtderp.xtdplatform.core.query.FullQueryResult;
import it.tasgroup.xtderp.xtdplatform.core.query.QueryResult;
import it.tasgroup.xtderp.xtdplatform.core.query.request.FilterRequest;
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
public final class JpaFullQuery<T> extends JpaQuery<T> {

    public JpaFullQuery(final Class<T> entityClass, final EntityManager manager, final I18n i18n) {
        super(manager, entityClass, i18n);
    }

    @Override
    public QueryResult find(Request request) throws Exception {
        JpaStatement<T> statement = new JpaStatement<>();
        new FilterRequest(request).filter().applyOn(statement);
        return
            new FullQueryResult(
                new ListOf<>(
                    new Mapped<>(
                        o -> new JpaEntity<>(o, this.metadata, this.manager),
                        this.repository.findAll(statement.get())
                    )
                )
            );
    }

}