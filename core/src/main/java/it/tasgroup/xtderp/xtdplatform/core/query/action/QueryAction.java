package it.tasgroup.xtderp.xtdplatform.core.query.action;

import it.tasgroup.xtderp.xtdplatform.core.action.Action;
import it.tasgroup.xtderp.xtdplatform.core.action.Request;
import it.tasgroup.xtderp.xtdplatform.core.action.Result;
import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.query.Query;
import it.tasgroup.xtderp.xtdplatform.core.query.QueryResult;
import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
abstract class QueryAction implements Action {

    protected final Query query;

    @Override
    public final Result execute(final Request request) throws Exception {
        return this.wrap(this.query.find(request));
    }

    @Override
    public final <T> Rendered<T> print(final Media<T> media) throws Exception {
        return media.asObject()
            .with("id", this.id())
            .with("type", "query")
            .with("modelId", this.query.modelId());
    }

    abstract Result wrap(QueryResult result);
}