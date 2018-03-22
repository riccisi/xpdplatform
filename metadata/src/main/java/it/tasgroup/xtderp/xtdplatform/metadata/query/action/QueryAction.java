package it.tasgroup.xtderp.xtdplatform.metadata.query.action;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Result;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.metadata.query.Query;
import it.tasgroup.xtderp.xtdplatform.metadata.query.QueryResult;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
abstract class QueryAction implements Action {

    final Query query;

    @Override
    public final Result execute(Request request) throws Exception {
        return this.wrap(this.query.find(request));
    }

    @Override
    public final <T> Rendered<T> print(Media<T> media) {
        return media.asObject()
            .with("id", this.id())
            .with("type", "query")
            .with("modelId", this.query.modelId());
    }

    abstract Result wrap(QueryResult queryResult);
}